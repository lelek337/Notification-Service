CREATE TABLE IF NOT EXISTS sms_inbox (
    id              UUID PRIMARY KEY,
    create_at       TIMESTAMP NOT NULL DEFAULT now(),
    topic           VARCHAR NOT NULL,
    key             VARCHAR NOT NULL,
    value           TEXT NOT NULL,
    processed       BOOLEAN NOT NULL,
    attempt         INTEGER NOT NULL
);

CREATE UNIQUE INDEX IF NOT EXISTS ux_sms_inbox_key_value ON sms_inbox ("key", value);

CREATE TABLE IF NOT EXISTS email_inbox (
    id              UUID PRIMARY KEY,
    create_at       TIMESTAMP NOT NULL DEFAULT now(),
    topic           VARCHAR NOT NULL,
    key             VARCHAR NOT NULL,
    value           TEXT NOT NULL,
    processed       BOOLEAN NOT NULL,
    attempt         INTEGER NOT NULL
);

CREATE UNIQUE INDEX IF NOT EXISTS ux_email_inbox_key_value ON email_inbox ("key", value);

CREATE TABLE IF NOT EXISTS push_inbox (
    id              UUID PRIMARY KEY,
    create_at       TIMESTAMP NOT NULL DEFAULT now(),
    topic           VARCHAR NOT NULL,
    key             VARCHAR NOT NULL,
    value           TEXT NOT NULL,
    processed       BOOLEAN NOT NULL,
    attempt         INTEGER NOT NULL
);

CREATE UNIQUE INDEX IF NOT EXISTS ux_push_inbox_key_value ON push_inbox ("key", value);

CREATE TABLE IF NOT EXISTS telegram_inbox (
    id              UUID PRIMARY KEY,
    create_at       TIMESTAMP NOT NULL DEFAULT now(),
    topic           VARCHAR NOT NULL,
    key             VARCHAR NOT NULL,
    value           TEXT NOT NULL,
    processed       BOOLEAN NOT NULL,
    attempt         INTEGER NOT NULL
);

CREATE UNIQUE INDEX IF NOT EXISTS ux_telegram_inbox_key_value ON telegram_inbox ("key", value);