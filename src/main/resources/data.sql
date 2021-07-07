DROP TABLE IF EXISTS hotel_review;

CREATE TABLE hotel_review (
  id VARCHAR(250)   PRIMARY KEY,
  hotel_id VARCHAR(250) NOT NULL,
  user_id VARCHAR(250) NOT NULL,
  review_id VARCHAR(250) NOT NULL,
  rating_id Int NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL
);
