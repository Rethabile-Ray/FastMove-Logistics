NB. Check login details below

# FastMove-Logistics
A multi-tier Jakarta EE enterprise web application for supply chain batch auditing, featuring container-managed security, stateful session analytics, and relational database logging.
## 2 Key Features
* **Container-Managed Security (Form-Based):** Implements server-managed authentication utilizing the GlassFish/Payara file realm with distinct security constraints for Administrators, Auditors, and Managers.
* **Stateful Conversational Audit Engine:** Manages continuous user state across HTTP Sessions to track real-time workforce metrics, matching efficiency indices, and live session token tracking.
* **Alphanumeric Variance Verification Logic:** Custom string processing algorithms that compare auditor inputs against masked automated system tokens to dynamically flag batches (`PRISTINE`, `TOLERABLE`, `CRITICAL_DISCREPANCY`).
* **EJB Architecture & JPA Persistence:** Utilizes Stateless Session Beans and the AbstractFacade pattern to log finalized audit metrics into a relational PostgreSQL database with custom sequence primary key mappings.
  
## 🛠️ Tech Stack & Enterprise Architecture
* **Backend Framework:** Jakarta EE / Java EE (Servlets, EJB 3.x, JPA / EclipseLink)
* **Security:** Container-Managed Form Authentication (`j_security_check` via GlassFish File Realm)
* **Database Engine:** JavaDB / Apache Derby (Embedded Relational Engine)
* **Application Server:** GlassFish / Payara Server
* **Enterprise Resources:** Managed JNDI Data Sources (`jdbc/__default` or custom Connection Pools)
* **Frontend UI:** HTML5, CSS3, dynamic JavaServer Pages (JSP)
* **Build Tool:** Ant / NetBeans Web Project Infrastructure

## 🔐 Demo Login Credentials

To test the role-based access control (RBAC) features of this application, use the following pre-configured server realm accounts:

* **Manager Account:**
  * **Username:** `exec_user`
  * **Password:** `123`
* **Standard Employee Account:**
  * **Username:** `clerk_user`
  * **Password:** `123`
 
    ## 🛠️ Infrastructure & Local Environment Setup

This application relies on container-managed resources bound within the application server. To deploy the application successfully without encountering EJB deployment exceptions or naming lookup failures, configure your local GlassFish / Payara instance with the following resource specifications:

### 1. JDBC Connection Pool Configuration
Navigate to **JDBC > JDBC Connection Pools** and modify or create a pool with the following parameters:
* **Pool Name:** `DerbyPool`
* **Resource Type:** `javax.sql.DataSource`
* **Classname:** `org.apache.derby.jdbc.ClientDataSource`

Under the **Additional Properties** tab, ensure the following key-value pairs are configured:
* `serverName`: `localhost`
* `PortNumber`: `1527`
* `DatabaseName`: `ExamFastMoveLogisticsDB`
* `User`: `app`
* `Password`: `123`
* `url`: `jdbc:derby://localhost:1527/ExamFastMoveLogisticsDB`

### 2. JDBC Resource (JNDI Mapping)
Navigate to **JDBC > JDBC Resources** and map the connection pool to the JNDI name expected by the application's `persistence.xml`:
* **JNDI Name:** `jdbc/fastmoveDS` *(Note: Ensure this matches your project's specific JNDI lookup string)*
* **Pool Name:** `DerbyPool`

### 3. Database Schema Lifecycle
The application uses JPA (EclipseLink) for Object-Relational Mapping. Ensure your local Apache Derby network server is running on port 1527 prior to deployment. On application startup, the underlying persistence provider is configured to automatically inspect the connection and generate the required database tables.
