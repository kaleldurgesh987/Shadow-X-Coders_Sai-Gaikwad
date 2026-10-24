# Project Plan

HomeCrew: Connecting Local Workers with Customers. A complete digital marketplace app connecting local workers (electricians, plumbers, carpenters, cleaners, painters, appliance repair, etc.) with customers. Features include: Splash Screen, Role Selection (Customer vs Worker), Customer Home (Search, Categories, Urgent help, Nearby workers, Bottom Nav), Service Categories, Job Request Form (with issue description, photos, location), Nearby Worker List, Worker Profile (Skills, Experience, Verified badge, Portfolio, Send Request), Quotation Comparison, Booking Confirmation, Track Booking (Request submitted, Quotation received, Worker assigned, In progress, Completed, Review & rating), Worker Dashboard (Today's jobs, Earnings, Total jobs, Incoming requests, My bookings, Earnings & history, Profile & skills), Earnings Ledger, Skill Passport (Verified worker, Skills, Experience, Customer rating, Certificates), Proof of Work (Before/After, Job details, Customer review), Worker Growth Roadmap, and Profile & Settings. UI design reference image is provided in the prompt.

## Project Brief

# Project Brief: HomeCrew - Minimum Viable Product (MVP)

## Project Overview
**HomeCrew** is a digital marketplace Android application connecting local service workers (electricians, plumbers, carpenters, cleaners, painters, appliance repair, etc.) with customers seeking reliable on-demand home services.

---

## Features (MVP)

1. **Role Selection & Authentication**
   - Initial onboarding screen allowing users to select their persona: **Customer** or **Worker**, tailoring the subsequent app experience and dashboard navigation.

2. **Service Discovery & Local Worker Browse**
   - Customers can browse core service categories, search for specific trades, and view nearby workers equipped with verified badges, skills, experience, and customer ratings.

3. **Job Request & Booking Tracking**
   - Streamlined job submission form supporting issue descriptions, photo attachments, and location tagging.
   - End-to-end booking lifecycle tracking: Request Submitted -> Quotation Received -> Worker Assigned -> In Progress -> Completed -> Review & Rating.

4. **Worker Dashboard & Job Management**
   - Dedicated workspace for workers to view incoming job requests, manage active bookings, track daily earnings, and update their skill passport and portfolio.

---

## High-Level Technical Stack

- **Programming Language**: Kotlin
- **UI Toolkit**: Jetpack Compose & Material 3
- **Navigation**: **Jetpack Navigation 3** (State-driven navigation architecture)
- **Layout & Adaptability**: **Compose Material Adaptive** library (Supporting adaptive multi-pane layouts across phones, foldables, and tablets)
- **Concurrency & Asynchronous State**: Kotlin Coroutines & `StateFlow` / `SharedFlow`
- **Architecture**: MVVM (Model-View-ViewModel) with Unidirectional Data Flow (UDF)

## Implementation Steps

### Task_1_RoleSelectionAndAuth: Implement Role Selection & Authentication (Customer vs Worker selection) with Jetpack Compose & MVVM.
- **Status:** COMPLETED
- **Updates:** Successfully implemented Role Selection & Authentication, theme, splash screen, and navigation infrastructure.
- **Acceptance Criteria:**
  - Role selection screen implemented
  - Customer and worker login/auth flow working
  - Project builds successfully
  - App does not crash
  - The implemented UI must match the design provided in design specs.

### Task_2_ServiceDiscoveryAndBrowse: Implement Service Discovery & Local Worker Browse (Categories, Search, Nearby Workers, Worker Profile, Quotation Comparison).
- **Status:** COMPLETED
- **Updates:** Successfully implemented Service Discovery & Local Worker Browse (Customer Home, Categories, Worker Profile, Quotation Comparison) with M3 and Navigation 3.

### Task_3_JobRequestAndBookingTracking: Implement Job Request & Booking Tracking (Job Request Form, Booking Confirmation, Booking Tracking lifecycle).
- **Status:** COMPLETED
- **Updates:** Successfully implemented Job Request Form, Booking Confirmation, and Booking Tracking timeline lifecycle screens.

### Task_4_WorkerDashboardAndJobManagement: Implement Worker Dashboard & Job Management (Worker Dashboard, Earnings Ledger, Skill Passport, Proof of Work, Growth Roadmap, Profile & Settings).
- **Status:** COMPLETED
- **Updates:** Successfully implemented Worker Dashboard, Earnings Ledger, Skill Passport, Proof of Work, Growth Roadmap, and Profile & Settings screens.

### Task_5_RunAndVerify: Run and verify the complete HomeCrew application MVP. Instruct critic_agent to verify application stability (no crashes), confirm alignment with user requirements, and report critical UI issues.
- **Status:** COMPLETED
- **Updates:** All tasks completed successfully. App builds cleanly, unit tests pass, all MVP features (Splash, Role Selection, Customer Home, Service Categories, Job Request Form, Worker Profile, Quotation Comparison, Booking Tracking, Worker Dashboard, Earnings Ledger, Skill Passport, Proof of Work, Growth Roadmap, Profile & Settings) are fully implemented.
- **Duration:** N/A

