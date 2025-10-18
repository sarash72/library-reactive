-- جدول کتاب‌ها
CREATE TABLE books (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       title VARCHAR(255) NOT NULL,
                       author VARCHAR(255),
                       isbn VARCHAR(50),
                       status VARCHAR(20) DEFAULT 'AVAILABLE'
);

-- جدول کاربران / اعضا
CREATE TABLE users (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- جدول امانت کتاب
CREATE TABLE borrow (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        book_id BIGINT NOT NULL,
                        user_id BIGINT NOT NULL,
                        borrow_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        return_date TIMESTAMP,
                        status VARCHAR(20) DEFAULT 'BORROWED',
                        CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES books(id),
                        CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);
