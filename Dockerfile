# ---------- مرحله ۱: Build با Maven ----------
FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /app

# کل پروژه (هم parent و هم submodules) را کپی کن
COPY . .

# پروژه را build کن (کل ماژول‌ها را)
RUN mvn clean package -DskipTests

# ---------- مرحله ۲: اجرای jar نهایی ----------
FROM eclipse-temurin:17-jdk
WORKDIR /app

# توجه: مسیر زیر را با مسیر و اسم jar اصلی خودت تنظیم کن
# فرض می‌کنیم ماژول اصلی member است و خروجی‌اش در target ساخته می‌شود
COPY --from=builder /app/member/target/member-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
