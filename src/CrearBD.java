import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CrearBD {
    public static void main(String[] args) {
        String dbPath = "jdbc:sqlite:cgStorage/cgDataBase/hormigas.sqlite";
        
        String[] queries = {
            "DROP TABLE IF EXISTS cgAlimentoPreparado",
            "DROP TABLE IF EXISTS cgHormiga",
            "DROP TABLE IF EXISTS cgEstadoHormiga",
            "DROP TABLE IF EXISTS cgSexo",
            "DROP TABLE IF EXISTS cgGenoma",
            "DROP TABLE IF EXISTS cgAlimentoTipo",
            "DROP TABLE IF EXISTS cgHormigaTipo",
            
            // cgHormigaTipo SIN UNIQUE
            """
            CREATE TABLE cgHormigaTipo (
                IdHormigaTipo  INTEGER PRIMARY KEY AUTOINCREMENT,
                Nombre         VARCHAR(20) NOT NULL,
                Descripcion    VARCHAR(50) NOT NULL,
                Estado         VARCHAR(1)  NOT NULL DEFAULT 'A',
                FechaCreacion  DATETIME NOT NULL DEFAULT (datetime('now','localtime')),
                FechaModifica  DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
            )
            """,
            
            // cgAlimentoTipo SIN UNIQUE
            """
            CREATE TABLE cgAlimentoTipo (
                IdAlimentoTipo  INTEGER PRIMARY KEY AUTOINCREMENT,
                Nombre          VARCHAR(20) NOT NULL,
                Descripcion     VARCHAR(50) NOT NULL,
                Estado          VARCHAR(1)  NOT NULL DEFAULT 'A',
                FechaCreacion   DATETIME NOT NULL DEFAULT (datetime('now','localtime')),
                FechaModifica   DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
            )
            """,
            
            // cgGenoma
            """
            CREATE TABLE cgGenoma (
                IdGenoma        INTEGER PRIMARY KEY AUTOINCREMENT,
                Nombre          VARCHAR(20) NOT NULL,
                Descripcion     VARCHAR(50) NOT NULL,
                Estado          VARCHAR(1)  NOT NULL DEFAULT 'A',
                FechaCreacion   DATETIME NOT NULL DEFAULT (datetime('now','localtime')),
                FechaModifica   DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
            )
            """,
            
            // cgSexo
            """
            CREATE TABLE cgSexo (
                IdSexo          INTEGER PRIMARY KEY AUTOINCREMENT,
                Nombre          VARCHAR(20) NOT NULL,
                Descripcion     VARCHAR(50) NOT NULL,
                Estado          VARCHAR(1)  NOT NULL DEFAULT 'A',
                FechaCreacion   DATETIME NOT NULL DEFAULT (datetime('now','localtime')),
                FechaModifica   DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
            )
            """,
            
            // cgEstadoHormiga
            """
            CREATE TABLE cgEstadoHormiga (
                IdEstadoHormiga INTEGER PRIMARY KEY AUTOINCREMENT,
                Nombre          VARCHAR(20) NOT NULL,
                Descripcion     VARCHAR(50) NOT NULL,
                Estado          VARCHAR(1)  NOT NULL DEFAULT 'A',
                FechaCreacion   DATETIME NOT NULL DEFAULT (datetime('now','localtime')),
                FechaModifica   DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
            )
            """,
            
            // cgHormiga
            """
            CREATE TABLE cgHormiga (
                IdHormiga       INTEGER PRIMARY KEY AUTOINCREMENT,
                IdHormigaTipo   INTEGER NOT NULL REFERENCES cgHormigaTipo(IdHormigaTipo),
                IdAlimentoTipo  INTEGER NOT NULL REFERENCES cgAlimentoTipo(IdAlimentoTipo),
                IdGenoma        INTEGER NOT NULL REFERENCES cgGenoma(IdGenoma),
                IdSexo          INTEGER NOT NULL REFERENCES cgSexo(IdSexo),
                IdEstadoHormiga INTEGER NOT NULL REFERENCES cgEstadoHormiga(IdEstadoHormiga),
                Nombre          VARCHAR(20) NOT NULL,
                Descripcion     VARCHAR(50) NOT NULL,
                Estado          VARCHAR(1)  NOT NULL DEFAULT 'A',
                FechaCreacion   DATETIME NOT NULL DEFAULT (datetime('now','localtime')),
                FechaModifica   DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
            )
            """,
            
            // cgAlimentoPreparado SIN UNIQUE
            """
            CREATE TABLE cgAlimentoPreparado (
                IdAlimentoPreparado INTEGER PRIMARY KEY AUTOINCREMENT,
                Nombre              VARCHAR(20) NOT NULL,
                Descripcion         VARCHAR(50) NOT NULL,
                Estado              VARCHAR(1)  NOT NULL DEFAULT 'A',
                FechaCreacion       DATETIME NOT NULL DEFAULT (datetime('now','localtime')),
                FechaModifica       DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
            )
            """,
            
            // Datos iniciales
            "INSERT INTO cgHormigaTipo(Nombre, Descripcion) VALUES ('Larva', 'Estado de larva')",
            "INSERT INTO cgHormigaTipo(Nombre, Descripcion) VALUES ('Soldado', 'Defensa')",
            "INSERT INTO cgHormigaTipo(Nombre, Descripcion) VALUES ('Rastreadora', 'Buscar comida')",
            "INSERT INTO cgHormigaTipo(Nombre, Descripcion) VALUES ('Reina', 'Permite reproduccion')",
            "INSERT INTO cgHormigaTipo(Nombre, Descripcion) VALUES ('Zangano', 'Macho para reproduccion')",
            
            "INSERT INTO cgAlimentoTipo(Nombre, Descripcion) VALUES ('Carnivoro', 'Azucar')",
            "INSERT INTO cgAlimentoTipo(Nombre, Descripcion) VALUES ('Hervivoro', 'Proteina')",
            "INSERT INTO cgAlimentoTipo(Nombre, Descripcion) VALUES ('Omnivoro', 'Lipidico')",
            "INSERT INTO cgAlimentoTipo(Nombre, Descripcion) VALUES ('Nectarivoro', 'Vitaminico')",
            
            "INSERT INTO cgGenoma(Nombre, Descripcion) VALUES ('X', 'Asexual')",
            "INSERT INTO cgGenoma(Nombre, Descripcion) VALUES ('XX', 'Macho')",
            "INSERT INTO cgGenoma(Nombre, Descripcion) VALUES ('XY', 'Hembra')",
            
            "INSERT INTO cgSexo(Nombre, Descripcion) VALUES ('Macho', 'Masculino')",
            "INSERT INTO cgSexo(Nombre, Descripcion) VALUES ('Hembra', 'Femenina')",
            "INSERT INTO cgSexo(Nombre, Descripcion) VALUES ('Hibrido', 'Hibrido')",
            "INSERT INTO cgSexo(Nombre, Descripcion) VALUES ('Asexual', 'Asexual')",
            
            "INSERT INTO cgEstadoHormiga(Nombre, Descripcion) VALUES ('Vive', 'Esta viva')",
            "INSERT INTO cgEstadoHormiga(Nombre, Descripcion) VALUES ('Muere', 'Ha muerto')",
            "INSERT INTO cgEstadoHormiga(Nombre, Descripcion) VALUES ('Finge', '...su muerte')"
        };
        
        try (Connection conn = DriverManager.getConnection(dbPath);
             Statement stmt = conn.createStatement()) {
            
            System.out.println("Creando base de datos...");
            
            for (String query : queries) {
                stmt.execute(query);
                String preview = query.split("\n")[0];
                if (preview.length() > 50) preview = preview.substring(0, 50);
                System.out.println("OK: " + preview + "...");
            }
            
            System.out.println("\n Base de datos creada exitosamente!");
            System.out.println("   Ubicacion: cgStorage/cgDataBase/hormigas.sqlite");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
