CREATE TABLE sales (
id SERIAL PRIMARY KEY,
order_id VARCHAR(50) UNIQUE,
product_name VARCHAR(100),
quantity INT,
price DECIMAL(10,2),
sale_date DATE,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE query_monitor (
id SERIAL PRIMARY KEY,
query_text TEXT,
execution_time_ms INT,
executed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);