## Car Rental

### Description
Web service for car rental company.

Non-commercial project.

### Tools
Java, Spring, Hibernate, MySQL, Thymeleaf, Bootstrap, JavaScript

### Features
- various ways of search (e.g. by car, by calendar)
- order flow based on three pages and resume page:
1. check date range
2. fill customer data 
3. make payment 
4. get resume
- validation every order flow page's forms
- mail sender (with order resume)
- cancel button on every page cleans current session
- when everything is fine all data is saved to MySQL DB

### Build, Run, Test
```
mvn install
mvn spring-boot:run
mvn test
```

### Screenshots

<table>
    <tr>
        <td>
            <img src="http://i.imgur.com/8tyBBlU.png" width="500">
        </td>
        <td>
            <img src="http://i.imgur.com/eCGDN4m.png" width="500">
        </td>
    </tr>
</table>

### FIXME
After a few months email sender stop working. Probably by blocking the mail address through the provider.
