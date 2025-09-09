# SonarQube Test Project

This project contains intentional code quality issues to test SonarQube analysis.

## Code Issues Included

### Security Issues
- SQL injection vulnerability in `getUserById()`
- Hardcoded credentials
- Public password field

### Code Smells
- Empty catch blocks
- Unused parameters and variables
- Magic numbers
- Duplicated code blocks
- High cyclomatic complexity
- Too many method parameters

### Bugs
- Resource leaks (unclosed files)
- Potential null pointer exceptions

### Test Issues
- Empty test methods
- Tests without assertions

## Running SonarQube Analysis

### 1. Start SonarQube Server
```bash
# Using Docker
docker run -d --name sonarqube -p 9000:9000 sonarqube:latest

# Or download and run locally
# Visit http://localhost:9000 (admin/admin)
```

### 2. Run Analysis
```bash
# Compile the project first
mvn clean compile test

# Run SonarQube analysis
mvn sonar:sonar

# Or with custom server URL
mvn sonar:sonar -Dsonar.host.url=http://localhost:9000
```

### 3. View Results
Open http://localhost:9000 and check your project analysis.

## Expected Findings

You should see issues in categories:
- **Bugs**: ~3-5 issues
- **Vulnerabilities**: ~2-3 issues  
- **Code Smells**: ~15-20 issues
- **Coverage**: Low test coverage
- **Duplications**: Duplicated code blocks

This gives you a realistic SonarQube testing environment with various types of code quality issues.
# awar04-sonarqube
