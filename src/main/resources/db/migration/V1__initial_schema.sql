CREATE TABLE object_document (
                                 id BIGINT PRIMARY KEY,
                                 name VARCHAR(255) NOT NULL,
                                 description TEXT,
                                 calculation_table_id BIGINT,
                                 created_at TIMESTAMP,
                                 updated_at TIMESTAMP,
                                 created_by VARCHAR(255),
                                 updated_by VARCHAR(255)
);

CREATE TABLE main_table (
                            id BIGINT PRIMARY KEY,
                            object_document_id BIGINT NOT NULL,
                            number_of_start INT NOT NULL,
                            type_of_record VARCHAR(50),
                            hidden BOOLEAN,
                            created_at TIMESTAMP,
                            updated_at TIMESTAMP,
                            created_by VARCHAR(255),
                            updated_by VARCHAR(255),
                            CONSTRAINT fk_object_document FOREIGN KEY (object_document_id) REFERENCES object_document(id)
);

CREATE TABLE calculation_table (
                                   id BIGINT PRIMARY KEY,
                                   number INT NOT NULL,
                                   command VARCHAR(255) NOT NULL,
                                   description TEXT,
                                   hidden BOOLEAN,
                                   created_at TIMESTAMP,
                                   updated_at TIMESTAMP,
                                   created_by VARCHAR(255),
                                   updated_by VARCHAR(255)
);

