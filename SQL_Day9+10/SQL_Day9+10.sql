 use sql_ringme1;
 
 /********* A. BASIC QUERY *********/
 -- 1. Liệt kê danh sách sinh viên sắp xếp theo thứ tự:
 -- a. id tăng dần
-- SELECT * FROM student
-- ORDER BY id ASC ;

 -- b. giới tính
--  SELECT * FROM student 
-- ORDER BY gender ASC;

-- c. ngày sinh TĂNG DẦN và học bổng GIẢM DẦN
-- SELECT * FROM student 
-- ORDER BY birthday ASC;

--  SELECT * FROM student 
-- ORDER BY scholarship DESC;

-- 2. Môn học có tên bắt đầu bằng chữ 'T'
-- SELECT * FROM subject 
-- WHERE name LIKE 'T%';

-- 3. Sinh viên có chữ cái cuối cùng trong tên là 'i'
-- SELECT * FROM student 
-- WHERE SUBSTR(name, -1,1) = 'i';

-- 4. Những khoa có ký tự thứ hai của tên khoa có chứa chữ 'n'
-- SELECT * FROM faculty 
-- WHERE SUBSTR(name, 2, 1) LIKE '%n%';

-- 5. Sinh viên trong tên có từ 'Thị'
-- SELECT * FROM student
-- WHERE name LIKE '%Thị%';

-- 6. Sinh viên có ký tự đầu tiên của tên nằm trong khoảng từ 'a' đến 'm', sắp xếp theo họ tên sinh viên
-- SELECT * FROM student
-- WHERE SUBSTR(name, 1, 1) BETWEEN 'a' AND 'm'
-- ORDER BY name;

-- 7. Sinh viên có học bổng lớn hơn 100000, sắp xếp theo mã khoa giảm dần
-- SELECT * FROM student
-- WHERE scholarship > 100000
-- ORDER BY faculty_id DESC;

-- 8. Sinh viên có học bổng từ 150000 trở lên và sinh ở Hà Nội
-- SELECT *FROM student
-- WHERE scholarship >= 150000 AND hometown LIKE '%Hà Nội%';

-- 9. Những sinh viên có ngày sinh từ ngày 01/01/1991 đến ngày 05/06/1992
-- SELECT * FROM student
-- WHERE birthday BETWEEN '1991-01-01'AND '1992-06-05';

-- 10. Những sinh viên có học bổng từ 80000 đến 150000
-- SELECT * FROM student
-- WHERE scholarship BETWEEN 80000 AND 150000;

-- 11. Những môn học có số tiết lớn hơn 30 và nhỏ hơn 45
-- SELECT * FROM student
-- WHERE scholarship BETWEEN 80000 AND 150000;

/********* B. CALCULATION QUERY *********/

-- 1. Cho biết thông tin về mức học bổng của các sinh viên, gồm: Mã sinh viên, Giới tính, Mã 
-- khoa, Mức học bổng. Trong đó, mức học bổng sẽ hiển thị là “Học bổng cao” nếu giá trị 
-- của học bổng lớn hơn 500,000 và ngược lại hiển thị là “Mức trung bình”.
-- SELECT *,
--     CASE
--         WHEN scholarship > 500000 THEN 'Học bổng cao'
--         ELSE 'Mức trung bình'
--     END AS scholarship_level
-- FROM student

-- 2. Tính tổng số sinh viên của toàn trường
-- SELECT count(st.id) AS "total student" FROM student st;

-- 3. Tính tổng số sinh viên nam và tổng số sinh viên nữ.
-- select st.gender,COUNT(st.gender) AS "Total gender"
-- FROM student st
-- GROUP BY st.gender;

-- 4. Tính tổng số sinh viên từng khoa
-- select st.faculty_id AS "id khoa",COUNT(*) AS "Total sinh viên"
-- FROM student st
-- GROUP BY st.faculty_id;

-- 5. Tính tổng số sinh viên của từng môn học
-- select em.subject_id as "id môn", COUNT(em.student_id) as "total sinh vien"
-- FROM exam_management em
-- GROUP BY em.subject_id;

-- 6. Tính số lượng môn học mà sinh viên đã học
-- select em.student_id as "id SV", COUNT(em.subject_id) as "total mon hoc"
-- FROM exam_management em
-- GROUP BY em.student_id ;

-- 7. Tổng số học bổng của mỗi khoa	
-- select st.faculty_id as "id khoa", COUNT(st.scholarship) as "số lượng học bổng"
-- FROM student st
-- GROUP BY st.faculty_id;

-- 8. Cho biết học bổng cao nhất của mỗi khoa
-- select st.faculty_id as "id khoa", MAX(st.scholarship) as "MAX "
-- FROM student st
-- GROUP BY st.faculty_id;

-- 9. Cho biết tổng số sinh viên nam và tổng số sinh viên nữ của mỗi khoa
-- SELECT st.faculty_id, 
--     COUNT(CASE WHEN gender = 'Nam' THEN 1 ELSE 0 END) AS male_students,
--     COUNT(CASE WHEN gender = 'Nữ' THEN 1 ELSE 0 END) AS female_students
-- FROM student st
-- GROUP BY st.faculty_id;

-- 10. Cho biết số lượng sinh viên theo từng độ tuổi
-- SELECT YEAR(st.birthday) AS "age", COUNT(*) AS "total sinh viên"
-- FROM student st
-- GROUP BY YEAR(st.birthday)
	
-- 11. Cho biết những nơi nào có ít nhất 2 sinh viên đang theo học tại trường
-- SELECT st.hometown from student st
-- group by st.hometown
-- having count(st.hometown)>=2;

-- 12. Cho biết những sinh viên thi lại ít nhất 2 lần
-- SELECT em.student_id from exam_management em
-- where em.number_of_exam_taking >="2"
-- group by em.student_id;

-- 13. Cho biết những sinh viên nam có điểm trung bình lần 1 trên 7.0 
-- SELECT st.name,st.gender From student st 
-- inner join exam_management em on st.id=em.student_id
-- Where st.gender="Nam" AND em.number_of_exam_taking=1
-- group by(st.name)
-- having avg(em.mark)>7.0; 

-- 14. Cho biết danh sách các sinh viên rớt ít nhất 2 môn ở lần thi 1 (rớt môn là điểm thi của môn không quá 4 điểm)
-- select em.student_id from exam_management em
-- where em.number_of_exam_taking=1
-- group by em.student_id
-- having sum(case when em.mark<=4 then 1 else 0 end)>=2;


-- 15. Cho biết danh sách những khoa có nhiều hơn 2 sinh viên nam
-- SELECT st.faculty_id From student st 
-- group by(st.faculty_id)
-- having sum( case when st.gender="Nam" then 1 else 0 end)>2;


-- 16. Cho biết những khoa có 2 sinh viên đạt học bổng từ 200000 đến 300000
-- SELECT st.faculty_id From student st 
-- group by(st.faculty_id)
-- having count(st.scholarship>=200000 and st.scholarship<=300000)>2;

-- 17. Cho biết sinh viên nào có học bổng cao nhất
-- SELECT st.name From student st 
-- where st.scholarship= (SELECT MAX(scholarship) FROM student);

-- -----------------------------------------------------------------

/********* C. DATE/TIME QUERY *********/

-- 1. Sinh viên có nơi sinh ở Hà Nội và sinh vào tháng 02
-- SELECT * FROM student
-- WHERE hometown = 'Hà Nội' AND MONTH(birthday) = 2;

-- 2. Sinh viên có tuổi lớn hơn 20
-- SELECT * FROM student
-- WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) > 20;

-- 3. Sinh viên sinh vào mùa xuân năm 1990
-- SELECT * FROM student
-- WHERE (MONTH(birthday) BETWEEN 1 AND 3) AND YEAR(birthday) = 1990;


-- -----------------------------------------------------------------


/********* D. JOIN QUERY *********/

-- 1. Danh sách các sinh viên của khoa ANH VĂN và khoa VẬT LÝ
-- SELECT st.* FROM student st
-- inner join faculty f on st.faculty_id=f.id
-- where f.name='Anh - Văn' or f.name='Vật lý';

-- 2. Những sinh viên nam của khoa ANH VĂN và khoa TIN HỌC
-- SELECT st.* FROM student st
-- inner join faculty f on st.faculty_id=f.id
-- where (f.name='Anh - Văn' or f.name='Tin học') and st.gender="Nam" ;

-- 3. Cho biết sinh viên nào có điểm thi lần 1 môn cơ sở dữ liệu cao nhất
-- SELECT st.*
-- FROM student st
-- INNER JOIN exam_management em ON st.id = em.student_id
-- where em.mark = (SELECT MAX(mark) FROM exam_management) and number_of_exam_taking = 1
-- GROUP BY st.id;

-- 4. Cho biết sinh viên khoa anh văn có tuổi lớn nhất.
-- SELECT st.name FROM student st
-- inner join faculty f on st.faculty_id=f.id
-- where f.id=1  and st.birthday = (SELECT MIN(birthday) FROM student where student.faculty_id=1)
-- Group by st.name

-- 5. Cho biết khoa nào có đông sinh viên nhất
--  select st.faculty_id, count(*) as "total" from student st
--  group by st.faculty_id 
--  order by count(*) desc
--  limit 1;
 
-- 6. Cho biết khoa nào có đông nữ nhất
--  select st.faculty_id, count(st.gender="Nữ") as "total nữ" from student st
--  group by st.faculty_id 
--  order by count(*) desc
--  limit 1;

-- 7. Cho biết những sinh viên đạt điểm cao nhất trong từng môn
-- select st.name,sb.name,em.mark from exam_management em
-- inner join student st on st.id=em.student_id
-- inner join subject sb on sb.id=em.student_id
-- where(em.subject_id,em.mark) in (select em.subject_id,max(em.mark) from exam_management em group by em.subject_id)

-- 8. Cho biết những khoa không có sinh viên học
-- select st.faculty_id, count(*) as "SL Sinh Vien" from student st
-- group by st.faculty_id
-- having count(*)=0;

-- 9. Cho biết sinh viên chưa thi môn cơ sở dữ liệu
-- SELECT st.name from student st 
-- inner join exam_management em on em.student_id=st.id
-- inner join subject sb on em.subject_id=sb.id
-- where sb.name="Cơ sở dữ liệu" and em.number_of_exam_taking is null;

-- 10. Cho biết sinh viên nào không thi lần 1 mà có dự thi lần 2
-- SELECT em.student_id, student.name FROM exam_management em
-- INNER JOIN student ON em.student_id = student.id
-- WHERE em.number_of_exam_taking >= 2
-- AND em.student_id NOT IN (
-- 	SELECT student_id
-- 	FROM exam_management
-- 	WHERE number_of_exam_taking = 1
-- )
-- GROUP BY em.student_id;


