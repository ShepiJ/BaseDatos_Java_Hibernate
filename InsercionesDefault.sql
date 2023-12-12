INSERT INTO person_js15 (DRIVER_ID,ADDRESS,NAME) VALUES ("personA","Sergio Alejo","c/Pez 1ºA");
INSERT INTO person_js15 (DRIVER_ID,ADDRESS,NAME) VALUES ("personB","Elia Bastian","c/Pez 1ºB");
INSERT INTO person_js15 (DRIVER_ID,ADDRESS,NAME) VALUES ("personC","Juan Clade","c/Pez 1ºC");

INSERT INTO car_js15 (LICENSE_ID,MODEL,YEAR, DRIVER_ID) VALUES ("carA","Ford Focus","2011","personA");
INSERT INTO car_js15 (LICENSE_ID,MODEL,YEAR, DRIVER_ID) VALUES ("carB","Seat Ibiza","2012","personA");
INSERT INTO car_js15 (LICENSE_ID,MODEL,YEAR, DRIVER_ID) VALUES ("carC","Renault Laguna","2013","personB");
INSERT INTO car_js15 (LICENSE_ID,MODEL,YEAR, DRIVER_ID) VALUES ("carD","Fiat Tipo","2014","personC");

INSERT INTO accident_js15 (REPORT_NUMBER,LOCATION) VALUES ("accA","Madrid");
INSERT INTO accident_js15 (REPORT_NUMBER,LOCATION) VALUES ("accB","Teruel");
INSERT INTO accident_js15 (REPORT_NUMBER,LOCATION) VALUES ("accC","Lugo");

INSERT INTO participated_js15 (LICENSE_ID,REPORT_NUMBER) VALUES ("carA","accA");
INSERT INTO participated_js15 (LICENSE_ID,REPORT_NUMBER) VALUES ("carB","accA");
INSERT INTO participated_js15 (LICENSE_ID,REPORT_NUMBER) VALUES ("carC","accB");
INSERT INTO participated_js15 (LICENSE_ID,REPORT_NUMBER) VALUES ("carD","accB");
INSERT INTO participated_js15 (LICENSE_ID,REPORT_NUMBER) VALUES ("carA","accC");
INSERT INTO participated_js15 (LICENSE_ID,REPORT_NUMBER) VALUES ("carD","accC");

INSERT INTO policy_js15 (POLICY_ID,LICENSE_ID) VALUES ("polA","carA");
INSERT INTO policy_js15 (POLICY_ID,LICENSE_ID) VALUES ("polB","carB");
