# ISyIESD
The objective of project *ISyIESD* was to create a simplified Transaction Manager and Concurrency Coordinator in order to manage distributed transactions and shared data access using the X/Open model. The focus was on coordinating K services executing read/write operations on M vector services. The project ensures the sum of the elements of each vector invariant through a system of distributed transactions:
 * The TransactionManager module coordinated the transactions between clients and resource managers 
 * TwoPhaseLockManager module handled locking mechanisms for shared resources
 * The VectorService module provided access to the shared resource (a vector of integers) and implemented the required methods for participating in two-phase commit 
 * The Client service demonstrated the use of the application and simulations. 
 
Together, these modules ensured transaction consistency and concurrency control. Distributed transactions were managed using the Two-Phase Commit (2PC) protocol, which provided atomicity, consistency, isolation, and durability (ACID) guarantees. The project is a Java EE, SOAP-based application that used XML for data transfer, making it platform-independent and flexible.

# ISystemK8s
The objective of second project *ISystemK8s* was to move the first work in Kubernetes in order to aid in software delivery and deployment. Despite some incompatibilities and challenges the code of first project was migrated to the Quarkus framework. Quarkus offeres advantages such as ease of deployment, faster startup times, native image compilation, and an active open-source community.