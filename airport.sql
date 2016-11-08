CREATE table AIRLINE(code varchar(2) primary key,Airlinename varchar(100),web varchar(100));

CREATE table PLANEMODEL(code varchar(100) primary key,capacity int);  

CREATE table FLIGHT(fnumber int not null,fsource varchar(100),fdetnition varchar(100),airlinecode varchar(2),modelcode varchar(100),foreign key(airlinecode) references AIRLINE(code),foreign key(modelcode) references PLANEMODEL(code),primary key(airlinecode,fnumber)); 
 
CREATE table INCOMING(airlinecode int,inumber int,arrivetime date,foreign key(airlinecode,inumber) references FLIGHT(airlinecode,fnumber),primary key(airlinecode,inumber)); 

CREATE table OUTGOING(airlinecode int,onumber int,departtime date,foreign key(airlinecode,onumber) references FLIGHT(airlinecode,fnumber),primary key(airlinecode,onumber));  

CREATE table PASSENGERS(pid int not null,pname varchar(100),dateofbirth varchar(100),placeofbirth varchar(100),citizenship varchar(100),primary key(pid));  

CREATE table ARRIVAL(gate varchar(100),arrivaldate date,arrstatus varchar(100),airlinecode int,inumber int,foreign key(airlinecode,inumber) references INCOMING(airlinecode,inumber),primary key(airlinecode,inumber,arrivaldate));  

CREATE table DEPART(gate varchar(100),departdate date,depstatus varchar(100),airlinecode int,onumber int,foreign key(airlinecode,onumber) references OUTGOING(airlinecode,onumber),primary key(airlinecode,onumber,departdate));  

CREATE table ARRIVALP(airlinecode int,inumber int,arrivaldate date,pid int,foreign key(airlinecode,inumber,arrivaldate) references ARRIVAL(airlinecode,inumber,arrivaldate),foreign key(pid) references PASSENGERS(pid));

CREATE table DEPARTP(airlinecode int,onumber int,departdate date,pid int,foreign key(airlinecode,onumber,departdate) references DEPART(airlinecode,onumber,departdate),foreign key(pid) references PASSENGERS(pid));

CREATE table CLASSES(classtype varchar(100),primary key(classtype)); 

CREATE table FIRSTCLASS(classtype varchar(100),particular varchar(100),foreign key(classtype) references CLASSES(classtype));

CREATE table REGULAR(classtype varchar(100),particular varchar(100),foreign key(classtype) references CLASSES(classtype));  

CREATE table INFANT(classtype varchar(100),particular varchar(100),foreign key(classtype) references CLASSES(classtype));  

CREATE table SPECIAL(classtype varchar(100),particular varchar(100),foreign key(classtype) references CLASSES(classtype));  

CREATE table BELONGTO(pid int,classtype varchar(100),foreign key(pid) references PASSENGERS(pid),foreign key(classtype) references CLASSES(classtype));

CREATE table CHECKIN(pid int,baggid int,baggagetype varchar(100),airlinecode int,fnumber int,foreign key(pid) references PASSENGERS(pid),foreign key(airlinecode,fnumber) references FLIGHT(airlinecode,fnumber));

Insert into AIRLINE values('01','AIR CANADA','webca');
Insert into AIRLINE values('02','WEST JET','webwe');
Insert into AIRLINE values('03','UNIT','webca');
Insert into PLANEMODEL values('01','100');

Insert into FLIGHT values('691','VICTORIA','VANA','01','');
Insert into FLIGHT values('692','VICTORIA','VANB','02','');
Insert into FLIGHT values('693','VICTORIA','VANC','01','');
Insert into FLIGHT values('694','VICTORIA','VAND','02','');
Insert into FLIGHT values('695','VICTORIA','VANE','03','');

Insert into INCOMING values('01','691',TO_DATE('03:00:00','HH24:MI:SS'));
Insert into INCOMING values('02','692',TO_DATE('21:00:00','HH24:MI:SS'));

Insert into OUTGOING values('01','693',TO_DATE('06:00:00','HH24:MI:SS'));
Insert into OUTGOING values('02','694',TO_DATE('20:00:00','HH24:MI:SS'));
Insert into OUTGOING values('03','695',TO_DATE('20:00:00','HH24:MI:SS'));

Insert into PASSENGERS values('001','wuxian','1','a','c');
Insert into PASSENGERS values('002','yiteng','2','b','c');
Insert into PASSENGERS values('003','xiaoming','3','c','c');
Insert into PASSENGERS values('004','liang','4','d','c');
Insert into PASSENGERS values('005','unknown','5','e','c');

Insert into ARRIVAL values('01',TO_DATE('01/05/2000','dd/mm/yy'),'on time','01','691');
Insert into ARRIVAL values('02',TO_DATE('01/05/2000','dd/mm/yy'),'on time','02','692');

Insert into DEPART values('01',TO_DATE('01/05/2000','dd/mm/yy'),'delay','01','693');
Insert into DEPART values('02',TO_DATE('01/05/2000','dd/mm/yy'),'delay','02','694');
Insert into DEPART values('02',TO_DATE('02/05/2000','dd/mm/yy'),'delay','03','695');

Insert into ARRIVALP values('01','691',TO_DATE('01/05/2000','dd/mm/yy'),'001');
Insert into ARRIVALP values('02','692',TO_DATE('01/05/2000','dd/mm/yy'),'002');
Insert into ARRIVALP values('03','695',TO_DATE('01/05/2000','dd/mm/yy'),'005');

Insert into DEPARTP values('01','693',TO_DATE('01/05/2000','dd/mm/yy'),'003');
Insert into DEPARTP values('02','694',TO_DATE('01/05/2000','dd/mm/yy'),'004');
Insert into DEPARTP values('03','695',TO_DATE('02/05/2000','dd/mm/yy'),'005');

CREATE view INCOME as select airlinecode,inumber,arrivaldate,arrivetime from ARRIVAL natural join INCOMING;
CREATE view OUTGO as select airlinecode,onumber,departdate,departtime from DEPART natural join OUTGOING;
select inumber,onumber from INCOME,OUTGO where (departdate = arrivaldate and (departtime - arrivetime)*24 <= 3 and (departtime - arrivetime)*24 > 0) or (departdate = arrivaldate + 1 and (departtime - arrivetime)*24 >= 21 and (departtime - arrivetime)*24 <= 24);

CREATE view IAP as select pid,arrivetime,arrivaldate from INCOMING natural join ARRIVALP;
CREATE view ODP as select pid,departtime,departdate from OUTGOING natural join DEPARTP;
select arrivalp.pid from arrivalp join departp on arrivalp.pid = departp.pid ; 



DROP table CHECKIN;
DROP table BELONGTO;
DROP table SPECIAL;
DROP table INFANT;
DROP table REGULAR;
DROP table FIRSTCLASS;
DROP table CLASSES;
DROP table DEPARTP;
DROP table ARRIVALP;
DROP table DEPART;
DROP table ARRIVAL;
DROP table PASSENGERS;
DROP table OUTGOING;
DROP table INCOMING;
DROP table FLIGHT;
DROP table PLANEMODEL;
DROP table AIRLINE;