
CREATE TABLE Social_Event (
    id SERIAL PRIMARY KEY,         -- 自增主键，使用整数类型
    tag VARCHAR(255) NOT NULL,
    start_time TIMESTAMPTZ NOT NULL, -- 开始时间
    end_time TIMESTAMPTZ NOT NULL,   -- 结束时间
    district VARCHAR(255) NOT NULL, -- 地址
    address VARCHAR(255) NOT NULL, -- 地址
    image_paths TEXT,            -- 图片路径列表，使用数组来存储多个图片路径
    title VARCHAR(255) NOT NULL,   -- 题目
    contact VARCHAR(255) NOT NULL, -- 联系人
    description TEXT               -- 介绍内容
);