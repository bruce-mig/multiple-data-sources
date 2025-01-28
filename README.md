# Multiple Data Sources in Spring Boot

## Description

This project demonstrates how to configure multiple JPA data sources in a single Spring Boot application. It is especially useful when you need to connect to multiple databases within a single application.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)

## Installation

1. **Clone the repository:**
    ```sh
    git clone https://github.com/bruce-mig/multiple-data-sources.git
    cd multiple-data-sources
    ```

2. **Build the project using Maven:**
    ```sh
    ./mvnw clean install
    ```

3. **Run the application:**
    ```sh
    ./mvnw spring-boot:run
    ```

## Usage

Once the application is running, it will connect to the configured databases.

## Configuration

To configure multiple data sources, follow these steps:

1. **Define Data Source Properties:**
   Add the properties for each data source in the `application.properties` or `application.yml` file.


## Contributing

Contributions are welcome! Please fork this repository and submit a pull request for any enhancements or bug fixes.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

---


There is a really good section in the Spring Boot Reference Documentation on [Configuring Two DataSources](https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.data-access.configure-two-datasources).