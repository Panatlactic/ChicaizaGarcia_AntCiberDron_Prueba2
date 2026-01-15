DROP TABLE IF EXISTS cgAlimentoPreparado;
DROP TABLE IF EXISTS cgHormiga;
DROP TABLE IF EXISTS cgEstadoHormiga;
DROP TABLE IF EXISTS cgSexo;
DROP TABLE IF EXISTS cgGenoma;
DROP TABLE IF EXISTS cgAlimentoTipo;
DROP TABLE IF EXISTS cgHormigaTipo;

-- creacion
CREATE TABLE cgHormigaTipo (
    IdHormigaTipo  INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre         VARCHAR(20) NOT NULL,
    Descripcion     VARCHAR(50) NOT NULL,

    Estado         VARCHAR(1)  NOT NULL DEFAULT 'A',
    FechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime')),
    FechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE cgAlimentoTipo (
    IdAlimentoTipo  INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre          VARCHAR(20) NOT NULL,
    Descripcion     VARCHAR(50) NOT NULL,

    Estado          VARCHAR(1)  NOT NULL DEFAULT 'A',
    FechaCreacion   DATETIME NOT NULL  DEFAULT (datetime('now','localtime')),
    FechaModifica   DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE cgGenoma (
    IdGenoma        INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre          VARCHAR(20) NOT NULL,
    Descripcion     VARCHAR(50) NOT NULL,

    Estado          VARCHAR(1)  NOT NULL DEFAULT 'A',
    FechaCreacion   DATETIME NOT NULL  DEFAULT (datetime('now','localtime')),
    FechaModifica   DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE cgSexo (
    IdSexo          INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre          VARCHAR(20) NOT NULL,
    Descripcion     VARCHAR(50) NOT NULL,

    Estado          VARCHAR(1)  NOT NULL DEFAULT 'A',
    FechaCreacion   DATETIME NOT NULL  DEFAULT (datetime('now','localtime')),
    FechaModifica   DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE cgEstadoHormiga (
    IdEstadoHormiga INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre          VARCHAR(20) NOT NULL,
    Descripcion     VARCHAR(50) NOT NULL,

    Estado          VARCHAR(1)  NOT NULL DEFAULT 'A',
    FechaCreacion   DATETIME NOT NULL  DEFAULT (datetime('now','localtime')),
    FechaModifica   DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE cgHormiga (
    IdHormiga       INTEGER PRIMARY KEY AUTOINCREMENT,
    IdHormigaTipo   INTEGER NOT NULL REFERENCES cgHormigaTipo(IdHormigaTipo),
    IdAlimentoTipo  INTEGER NOT NULL REFERENCES cgAlimentoTipo(IdAlimentoTipo),
    IdGenoma        INTEGER NOT NULL REFERENCES cgGenoma(IdGenoma),
    IdSexo          INTEGER NOT NULL REFERENCES cgSexo(IdSexo),
    IdEstadoHormiga INTEGER NOT NULL REFERENCES cgEstadoHormiga(IdEstadoHormiga),

    Nombre          VARCHAR(20) NOT NULL ,
    Descripcion     VARCHAR(50) NOT NULL,
    
    Estado          VARCHAR(1)  NOT NULL DEFAULT 'A',
    FechaCreacion   DATETIME NOT NULL  DEFAULT (datetime('now','localtime')),
    FechaModifica   DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE cgAlimentoPreparado (
    IdAlimentoPreparado     INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre          VARCHAR(20) NOT NULL ,
    Descripcion     VARCHAR(50) NOT NULL,

    Estado          VARCHAR(1)  NOT NULL DEFAULT 'A',
    FechaCreacion   DATETIME NOT NULL  DEFAULT (datetime('now','localtime')),
    FechaModifica   DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

-- Insercion
INSERT INTO cgHormigaTipo(Nombre, Descripcion)
VALUES
    ('Larva', 'Estado de larva'),
    ('Soldado', 'Defensa'),
    ('Rastreadora', 'Buscar comida'),
    ('Reina', 'Permite reproducción'),
    ('Zángano', 'Macho para reproducción')
;

INSERT INTO cgAlimentoTipo (Nombre, Descripcion)
VALUES
    ('Carnívoro', 'Azucar'),
    ('Hervíboro', 'Proteína'),
    ('Omnívoro', 'Lipidico'),
    ('Nectarívoro', 'Vitaminico')
;

INSERT INTO cgGenoma (Nombre, Descripcion)
VALUES
    ('X', 'Asexual'),
    ('XX', 'Macho'),
    ('XY', 'Hembra')
;

INSERT INTO cgSexo (Nombre, Descripcion)
VALUES
    ('Macho', 'Masculino'),
    ('Hembra', 'Femenina'),
    ('Hibrido', 'Hibrido'),
    ('Asexual', 'Asexual')
;

INSERT INTO cgEstadoHormiga (Nombre, Descripcion)
VALUES
    ('Vive', 'Esta viva'),
    ('Muere', 'Ha muerto'),
    ('Finge', '...su muerte')
;

-- llenar cgAlimentoPreparado
-- llenar cgHormiga

-- View
DROP VIEW IF EXISTS cgViewHormiga;

CREATE VIEW cgViewHormiga AS
SELECT
    H.IdHormiga,
    HT.Nombre  AS TipoHormiga,
    AT.Nombre  AS TipoAlimento,
    GN.Nombre  AS Genoma,
    S.Nombre   AS Sexo,
    EH.Nombre  AS EstadoHormiga,
    H.Nombre   AS Nombre,
    H.Descripcion,
    H.Estado,
    H.FechaCreacion,
    H.FechaModifica
FROM cgHormiga               H
JOIN cgHormigaTipo          HT ON H.IdHormigaTipo = HT.IdHormigaTipo
JOIN cgAlimentoTipo         AT ON H.IdAlimentoTipo = AT.IdAlimentoTipo
JOIN cgGenoma               GN ON H.IdGenoma = GN.IdGenoma
JOIN cgSexo                 S  ON H.IdSexo = S.IdSexo
JOIN cgEstadoHormiga        EH ON H.IdEstadoHormiga = EH.IdEstadoHormiga
WHERE H.Estado = 'A';
