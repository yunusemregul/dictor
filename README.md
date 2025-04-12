# Dictor

A simple in-memory key-value store with Redis-like commands, built in Java.

## Overview

Dictor is a lightweight, distributed key-value storage system with a master-slave architecture. It was built for a company developer meeting and created in just 1-2 days as a demonstration project.

## Features

- In-memory key-value storage
- TCP-based client-server architecture
- Multiple client connections support
- Command-based query system
- Master-slave architecture (work in progress)

## Commands

The following commands are supported:

- `GET` - Retrieve a value for a given key
- `SET` - Store a key-value pair
- `DEL` - Delete a key-value pair
- `EXISTS` - Check if a key exists
- `APPEND` - Append a value to an existing key
- `PING` - Test server connection

## Architecture

The project consists of two modules:

- **slave**: The storage server that handles client connections and processes commands
- **master**: A work-in-progress module for distributed coordination (not fully implemented)

## Building and Running

The project uses Maven for dependency management.

To build the project:
```
mvn clean package
```

To run the slave server:
```
java -jar slave/target/slave-1.0-SNAPSHOT.jar
```

## Technical Details

- Java 8+
- Multi-threaded server design
- TCP sockets for communication
- Singleton pattern for the Dictor instance
- Command pattern for operation handling

## Limitations

As this was a quick 1-2 day project for a company developer meeting, it has several limitations:
- No persistence
- Limited error handling
- Master node not fully implemented
- Basic command set
- Single-instance storage (no sharding) 