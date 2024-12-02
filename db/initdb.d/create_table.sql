CREATE TABLE 'pass'
(
    'pass_seq' int NOT NULL AUTO_INCREMENT COMMENT '이용권 순번',
    'package_seq' int NOT NULL COMMENT '패키지 순번',
    'user_id' varchar(20) NOT NULL COMMENT '사용자 ID',
    'status' varchar(10) NOT NULL COMMENT '상태',
    'remaining_count' int DEFAULT NULL COMMENT '잔여 이용권 수, NULL인 경우 무제한',
    'started_at' timestamp NOT NULL COMMENT '시작 일시',
    'ended_at' timestamp DEFAULT NULL COMMENT '종료 일시, NULL인 경우 무제한',
    'expired_at' timestamp DEFAULT NULL COMMENT '만료 일시',
    'created_at' timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일시',
    'modified_at' timestamp DEFAULT NULL COMMENT '수정 일시',
    PRIMARY KEY('pass_seq')
) ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='이용권';
