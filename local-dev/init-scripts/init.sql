-- Connect to the mbankdb database (already created by POSTGRES_DB environment variable)
\c mbankdb

-- Create read_write role if it doesn't exist
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_roles WHERE rolname = 'read_write') THEN
        CREATE ROLE read_write;
    END IF;
END
$$;

-- Grant role to user
GRANT read_write TO mbank;

-- Create tables
CREATE TABLE IF NOT EXISTS marca (
    id_marca SERIAL PRIMARY KEY,
    codigo INTEGER NOT NULL,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS veiculo (
    id_veiculo SERIAL PRIMARY KEY,
    id_marca INTEGER NOT NULL,
    codigo INTEGER NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    observacao VARCHAR(1000),
    FOREIGN KEY (id_marca) REFERENCES marca(id_marca)
);

-- Grant privileges on tables
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO read_write;

-- Grant privileges on sequences (for SERIAL columns)
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO read_write;