create table accounts (
                              accountNumber bigint auto_increment,
                              name varchar(255) NOT NULL,
                              accountType varchar(255),
                              ifsc_code varchar(255),
                              pan varchar(255),
                              branch varchar(255),
                              aadhar_number varchar(255) NOT NULL,
                              create_date TIMESTAMP,
                              phone varchar(255),
                              address varchar(255),
                              balance bigint
                              PRIMARY KEY (accountNumber)
);

create table transactions (
                              transactionId bigint auto_increment,
                              amount bigint NOT NULL,
                              txn_date TIMESTAMP,
                              type varchar(40) NOT NULL
                              PRIMARY KEY (transactionId)
                              FOREIGN KEY (accountNumber) REFERENCES accounts(accountNumber)
);