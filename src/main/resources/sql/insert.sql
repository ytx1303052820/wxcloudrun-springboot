DELETE FROM Social_Event;

INSERT INTO Social_Event (id,tag, start_time, end_time, address, image_paths,district,  title, contact, description)
VALUES
('da494ecb-4fe1-41d6-bf52-fa7ded137d78','商家活动', '2024-06-01 10:00:00+08', '2024-06-01 12:00:00+08', '泡泡海啤酒馆(中山广场店)', '{"path/to/image1.jpg", "path/to/image2.jpg"}','中山区' ,'啤酒艺术家挑战赛', 'John Doe', 'A meeting to discuss community issues and plans.'),
('098f6bcd-4621-3373-8ade-4e832627b4f6','国际交流', '2024-05-26 14:00:00+08', '2024-05-26 16:00:00+08', '更新街2号Q Café（青泥洼桥地铁站C口步行440米)', '{"pic1.jpg", "pic2.jpg"，"pic3.jpg","pic4.jpg","pic5.jpg"}', '中山区','中日交流会', '张老师', '大家好啊你好中国语教室举办的中日文化分享公益沙龙活动好久没有和大家见面啦！经常有小伙伴们问我下次活动是什么时候，很感恩大家的喜爱和支持我们将于5月26日（日）14:00～16:00在QCafe举行第八期特别活动，欢迎会说中日英的新老朋友参加。PS：免费参加，饮品自付。考虑到交流的效果，仅限20人。欲报从速，额满为止呦～'),
('55d53929-8938-405e-bdea-a8a109e8f387','读书会', '2024-08-21 09:00:00+08', '2024-08-21 11:00:00+08', '西安路街角时光', '{"path/to/image5.jpg"}', '沙河口区', 'MBTI讲解','Dane', 'A conference for tech enthusiasts to learn about the latest in technology.'),
('fbe31a78-cb9b-4586-b0c2-8cc2bb1eb0c8','创业局', '2024-09-10 13:00:00+08', '2024-09-10 15:00:00+08', '山人集咖啡馆', '{"path/to/image6.jpg", "path/to/image7.jpg", "path/to/image8.jpg"}', '西岗区','创业故事', 'Bob Brown', 'An exhibition showcasing the work of local artists.'),
('5449f058-61b9-4201-aeea-c2ddeeb9edfa','疗愈局', '2024-10-05 18:00:00+08', '2024-10-05 21:00:00+08', '33花咖(中央大道店)', '{"path/to/image9.jpg"}', '沙河口区','身心疗愈', 'Chris Green', 'A live concert featuring various bands and artists.');
