INSERT INTO
    medicom.roles (id, name)
VALUES (1, 'ADMIN'), (2, 'DOCTOR'), (3, 'NURSE')
ON DUPLICATE KEY UPDATE
    id = id
;