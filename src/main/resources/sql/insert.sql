DELETE FROM Social_Event;

INSERT INTO Social_Event (tag, start_time, end_time, address, image_paths,district,  title, contact, description)
VALUES
('商家活动', '2024-06-01 10:00:00+08', '2024-06-01 12:00:00+08', '泡泡海啤酒馆(中山广场店)', '{"path/to/image1.jpg", "path/to/image2.jpg"}','中山区' ,'啤酒艺术家挑战赛', 'John Doe', 'A meeting to discuss community issues and plans.'),
('英语交流', '2024-07-15 14:00:00+08', '2024-07-15 17:00:00+08', '更新街2号Q Cafe', '{"path/to/image3.jpg", "path/to/image4.jpg"}', '中山区','中日交流会', 'Jane Smith', 'An annual festival with fun activities, food, and music.'),
('读书会', '2024-08-21 09:00:00+08', '2024-08-21 11:00:00+08', '西安路街角时光', '{"path/to/image5.jpg"}', '沙河口区', 'MBTI讲解','Dane', 'A conference for tech enthusiasts to learn about the latest in technology.'),
('创业局', '2024-09-10 13:00:00+08', '2024-09-10 15:00:00+08', '山人集咖啡馆', '{"path/to/image6.jpg", "path/to/image7.jpg", "path/to/image8.jpg"}', '西岗区','创业故事', 'Bob Brown', 'An exhibition showcasing the work of local artists.'),
('疗愈局', '2024-10-05 18:00:00+08', '2024-10-05 21:00:00+08', '33花咖(中央大道店)', '{"path/to/image9.jpg"}', '沙河口区','身心疗愈', 'Chris Green', 'A live concert featuring various bands and artists.');
