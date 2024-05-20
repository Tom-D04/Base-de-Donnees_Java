# Compte rendu Java - Base de Données

*
    Tom Dunand - 3A - TD2 - TP4*

---

## Objectifs

L'objectif de ce TD est de se connecter à une base de donnée avec Java, faire en sorte de pouvoir l'administrer et d'effectue des requêtes SQL enfin de sécuriser un minimum l'accès à la base de donnée.

## Connexion

La connexion à la base de données va se faire via un driver JDBC qui prend en charge MySQL. Pour l'utiliser, on a crée une méthode `connect()` dans la classe `MYSQLDatabase` :

```java
public void connect() {
        try {
            this.connection = DriverManager.getConnection(
                "jdbc:mysql://" + host + ":" + port + "/" + databaseName + "?allowMultiQueries=true",
                user,
                password
            );
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    } 
```

On se connecte à la BDD grâce à la méthode `getConnection() `du module ` DriverManager`  avec la connection_string "jdbc:mysql://hostname:portNumber/databaseName" fournie dans le sujet, dans laquelle on remplace les différentes valeurs par celles passées en paramètre du constructeur. La chaîne "?allowMultiQueries=true" nous authorizera à effectuer des requêtes multiples sur la DB.

Paramètres du contructeur : ` public MYSQLDatabase(String host, int port, String databaseName, String user, String password).`

## Requêtes

#### Statement

Pour pouvoir effectuer une requête SQL, on utilise le module `Java.sql` qui nus permet d'abour de créer un 'Statement' qui est un objet qui nous fourni la méthode `executeQuery()` qui permet quant à elle d'exécuter une requête.

```java
public Statement createStatement() {
        try {
            return connection.createStatement();
        } catch (Exception sqlException) {
            System.err.println(sqlException.getMessage());
            return null;
        }
    }
```

Ici on crée uniquement un `Statement` sur la connexion ouvert précédemment.

#### Requêtes

La méthode simple pour faire des requêtes sur la DB à partir d'un `Statement` est la suivante :

```java
statement = connection.createStatement()
statement.executeQuery("SELECT * FROM sport;")
```

Nous avons par la suite implémenté cela dans des classes
