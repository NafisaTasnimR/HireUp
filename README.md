## HIRE UP 

## Overview
HireUp is a console-based Java application designed to connect job applicants with job providers. The system allows job seekers to search and apply for jobs, job providers to post and manage job listings, and an admin to oversee the entire platform.

## Features
## User Roles
- **Admin**: Manages job providers, applicants, and requests.
- **Job Provider**: Posts job listings and reviews applications.
- **Applicant**: Searches for jobs, applies for job positions, and manages their resume.

### Functionalities
***** Admin *****
- View and delete job providers.
- View and delete applicants.
- Approve or reject job provider requests.
- Approve or reject applicant requests.

***** Job Provider *****
- Post job listings.
- Review applicants for posted jobs.
- Shortlist or reject applicants.
- View shortlisted applicants.

***** Applicant *****
- Search for jobs based on preferences.
- View job details and apply.
- Create, update, and manage a resume.
- Track application status.

## Installation
### Prerequisites
- Java Development Kit (JDK) 8 or later
- A text editor or IDE (e.g., IntelliJ, Eclipse, VS Code)

### Setup
1. Clone or download the project.
2. Open the project in your preferred IDE.
3. Ensure the `HireUpMain` package is set up correctly.
4. Compile and run `Main.java` to start the application.

## How to Use
1. **Run the application**: Execute `Main.java`.
2. **Login or Sign Up**:
   - Existing users can log in by providing credentials.
   - New users must register as either an Applicant or Job Provider.
3. **Navigate through the system** based on your role:
   - Applicants can search and apply for jobs.
   - Job Providers can post jobs and manage applicants.
   - Admins can manage users and job postings.
4. **Exit the system** when finished.

## Project Structure
- `Admin.java` - Handles admin functionalities.
- `Applicant.java` - Manages applicant actions.
- `Job.java` - Represents job postings.
- `JobProvider.java` - Manages job provider activities.
- `Main.java` - Entry point of the application.
- `Resume.java` - Handles resume creation and storage.
- `User.java` - Base class for all users.
- `Utility.java` - Provides helper methods.

## Contributors
- Nishat Tasnim
- Nafisa Tasnim
- Mrittika Jahan
