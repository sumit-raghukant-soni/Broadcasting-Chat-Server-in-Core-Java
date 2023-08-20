# Broadcasting Chat Server in Core Java
Welcome to the Broadcasting Chat Server GitHub repository! This project demonstrates a simple broadcasting chat server implemented in Core Java. The server allows multiple clients to connect and exchange messages in a broadcast fashion, where any message sent by one client is received by all connected clients.

Sources : [Javatpoint] (https://www.javatpoint.com/)


## Table of Contents
Features
Getting Started
Prerequisites
Running the Server
Connecting Clients
Usage
Contributing
License
Features
Broadcast Messaging: Messages sent by any client are broadcasted to all connected clients.
Simple Interface: The server and client interfaces are designed to be easy to understand and use.
Threaded Architecture: Each client connection is handled in a separate thread to allow concurrent communication.


## Getting Started

### Prerequisites
To run the broadcasting chat server, you need to have the following prerequisites:
Java Development Kit (JDK) installed on your machine (version X or later).

### Running the Server
Clone this repository to your local machine or download the source code as a ZIP file.
Open a terminal or command prompt and navigate to the root directory of the project.
Compile the server source code using the following command:

sh
Copy code
javac Server.java
Run the server using the following command:

sh
Copy code
java Server
The server will start and listen for client connections on a specified port (default is 12345).

### Connecting Clients

Open a new terminal or command prompt for each client you want to simulate.
Navigate to the root directory of the project.
Compile the client source code using the following command:

sh
Copy code
javac Client.java
Run the client using the following command:

sh
Copy code
java Client
The client will prompt you to enter a username.

Once you've entered a username, you can start sending and receiving messages through the server.


## Usage
The server supports multiple clients simultaneously. Each message sent by a client will be broadcasted to all other connected clients.
Clients can disconnect by entering a predefined command (e.g., "/quit").


## Contributing
Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

Fork the repository.
Create a new branch for your feature or bug fix.
Make your changes and commit them with descriptive commit messages.
Push your changes to your fork.
Create a pull request explaining your changes and why they should be merged.

We hope you find this Broadcasting Chat Server project helpful and educational. If you have any questions or suggestions, please don't hesitate to open an issue or pull request. Happy coding! 🚀