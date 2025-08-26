CREATE TABLE IF NOT EXISTS sms_inbox (
    id              UUID PRIMARY KEY,
    create_at       TIMESTAMP NOT NULL DEFAULT now(),
    topic           VARCHAR NOT NULL,
    key             VARCHAR NOT NULL,
    value           TEXT NOT NULL,
    processed       BOOLEAN NOT NULL,
    attempt         INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS email_inbox (
    id              UUID PRIMARY KEY,
    create_at       TIMESTAMP NOT NULL DEFAULT now(),
    topic           VARCHAR NOT NULL,
    key             VARCHAR NOT NULL,
    value           TEXT NOT NULL,
    processed       BOOLEAN NOT NULL,
    attempt         INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS push_inbox (
    id              UUID PRIMARY KEY,
    create_at       TIMESTAMP NOT NULL DEFAULT now(),
    topic           VARCHAR NOT NULL,
    key             VARCHAR NOT NULL,
    value           TEXT NOT NULL,
    processed       BOOLEAN NOT NULL,
    attempt         INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS telegram_inbox (
    id              UUID PRIMARY KEY,
    create_at       TIMESTAMP NOT NULL DEFAULT now(),
    topic           VARCHAR NOT NULL,
    key             VARCHAR NOT NULL,
    value           TEXT NOT NULL,
    processed       BOOLEAN NOT NULL,
    attempt         INTEGER NOT NULL
);