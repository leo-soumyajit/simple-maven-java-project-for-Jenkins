```markdown
# 🚀 Java CI/CD Pipeline Project

This is a simple Java Maven application designed to demonstrate a complete **DevOps CI/CD Pipeline** using **Jenkins, Docker, and AWS**.

## 🛠️ Tech Stack
* **Language:** Java 17
* **Build Tool:** Maven
* **Containerization:** Docker
* **CI/CD Server:** Jenkins
* **Registry:** Docker Hub
* **Cloud Provider:** AWS (EC2)

## ⚙️ How to Run Locally
If you have Docker installed, you can run this app with a single command:

```bash
docker run -d -p 8000:5000 soumyajit2005/my-java-app:latest

```

Access the application at: `http://localhost:8000`

## 🔄 CI/CD Pipeline Workflow

This project uses a **Jenkinsfile** to automate the deployment process. Every time code is pushed to the `main` branch, Jenkins performs the following steps:

1. **Checkout:** Pulls the latest code from GitHub.
2. **Test:** Runs Unit Tests (`mvn test`) to ensure code quality.
3. **Build:** Compiles the code and packages it into a JAR file.
4. **Dockerize:** Builds a lightweight Docker image (Alpine based).
5. **Push:** Pushes the image to **Docker Hub**.
6. **Deploy:** Pulls the fresh image on the AWS EC2 server and runs it on port **8000**.

## 📂 Project Structure

```
├── src/               # Source code and Tests
├── Dockerfile         # Docker configuration (Multi-stage build)
├── Jenkinsfile        # CI/CD Pipeline Script (Groovy)
└── pom.xml            # Maven dependencies

```

---

*Created by Soumyajit*

```

### 📝 Isse GitHub par kaise dalein?
Agar terminal se karna hai toh ye commands chalao:

```bash
# 1. File create karo (Agar VS Code mein ho toh wahan file bana kar paste karo)
# Phir ye commands chalao:

git add README.md
git commit -m "Added README documentation"
git push origin main

```