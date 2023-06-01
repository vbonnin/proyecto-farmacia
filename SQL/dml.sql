INSERT INTO doctor (mail, pass, name)
VALUES 
('HouseMD@gmail.com', '1234', 'House M.D.'),
('DerekShepherd@gmail.com', '1234', 'Derek Shepherd'),
('MeredithGrey@gmail.com', '1234', 'Meredith Grey'),
('AmeliaShepherd@gmail.com', '1234', 'Amelia Shepherd'),
('CristinaYang@gmail.com', '1234', 'Cristina Yang'),
('MirandaBailey@gmail.com', '1234', 'Miranda Bailey'),
('AlexKarev@gmail.com', '1234', 'Alex Karev'),
('RichardWebber@gmail.com', '1234', 'Richard Webber'),
('ArizonaRobbins@gmail.com', '1234', 'Arizona Robbins'),
('CallieTorres@gmail.com', '1234', 'Callie Torres');

INSERT INTO patient (mail, name)
VALUES 
('ElonMusk@gmail.com', 'Elon Musk'),
('BillGates@gmail.com', 'Bill Gates'),
('JeffBezos@gmail.com', 'Jeff Bezos'),
('MarkZuckerberg@gmail.com', 'Mark Zuckerberg'),
('LarryPage@gmail.com', 'Larry Page'),
('SergeyBrin@gmail.com', 'Sergey Brin'),
('TimCook@gmail.com', 'Tim Cook'),
('SatyaNadella@gmail.com', 'Satya Nadella'),
('JackDorsey@gmail.com', 'Jack Dorsey'),
('SundarPichai@gmail.com', 'Sundar Pichai');

INSERT INTO medicine (id, name, tmax, tmin)
VALUES 
(1, 'Ibuprofen', 24.5, 18.3),
(2, 'Paracetamol', 30.5, 22.8),
(3, 'Aspirin', 28.0, 20.5),
(4, 'Metformin', 25.2, 18.0),
(5, 'Simvastatin', 24.5, 16.8),
(6, 'Levothyroxine', 27.5, 19.2),
(7, 'Amoxicillin', 28.8, 20.5),
(8, 'Lisinopril', 26.5, 18.2),
(9, 'Omeprazole', 25.5, 17.8),
(10, 'Citalopram', 28.5, 20.2);

INSERT INTO xip (id, doctor_mail, id_medicine, id_patient, date)
VALUES 
(1, 'HouseMD@gmail.com', 1, 'ElonMusk@gmail.com', '2023-05-31'),
(2, 'DerekShepherd@gmail.com', 2, 'BillGates@gmail.com', '2023-05-30'),
(3, 'MeredithGrey@gmail.com', 3, 'JeffBezos@gmail.com', '2023-05-29'),
(4, 'AmeliaShepherd@gmail.com', 4, 'MarkZuckerberg@gmail.com', '2023-05-28'),
(5, 'CristinaYang@gmail.com', 5, 'LarryPage@gmail.com', '2023-05-27'),
(6, 'MirandaBailey@gmail.com', 6, 'SergeyBrin@gmail.com', '2023-05-26'),
(7, 'AlexKarev@gmail.com', 7, 'TimCook@gmail.com', '2023-05-25'),
(8, 'RichardWebber@gmail.com', 8, 'SatyaNadella@gmail.com', '2023-05-24'),
(9, 'ArizonaRobbins@gmail.com', 9, 'JackDorsey@gmail.com', '2023-05-23'),
(10, 'CallieTorres@gmail.com', 10, 'SundarPichai@gmail.com', '2023-05-22');
