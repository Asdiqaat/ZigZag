# Zigzag Program – Task 10 (SwiftBot)

## 📌 Introduction
The Zigzag program controls a **SwiftBot** robot to traverse a zigzag path based on inputs scanned from a QR code.  
This project was implemented as part of Task 10 and documents the design, functionality, testing, and changes made during development.  

The program:
- Uses a **command-line interface** with ASCII art, colors, and clear instructions.  
- Validates QR code input (`value_1:value_2`).  
- Controls SwiftBot movement, LED lights, and journey logging.  
- Provides additional user features for customization and error handling.  

---

## ⚙️ Implementation Summary
- Built as a **CLI-based Python program** with SwiftBot API integration.  
- Functional, non-functional, and additional requirements were all implemented.  
- Log files are created and updated after each journey, including user inputs, speed, and performance data.  
- Testing was conducted continuously during development, followed by a structured test plan.  

---

## ✅ Required Functionalities
The program implements the following **functional requirements**:

1. Display instructions and button actions (`Y` to scan QR, `X` to quit).  
2. Validate QR code format (`value_1:value_2`).  
3. Ensure `value_1` is **15–85 cm** and `value_2` is **even, ≤ 12**.  
4. Randomly generate SwiftBot wheel speed.  
5. Control LED lights:  
   - Green = odd zigzag sections  
   - Blue = even zigzag sections  
6. Traverse zigzag path and retrace it to the starting point.  
7. Pause **1 second** between sections.  
8. Detect and report errors in movement.  
9. Write journey logs to a text file, including:  
   - User inputs  
   - Wheel speed  
   - Path length and straight-line distance  
   - Journey duration  
10. Maintain all journey records until program exit.  
11. On exit, display:  
   - Total journeys completed  
   - Longest/shortest journey (straight-line distance)  
   - File path to log file  

### Non-functional requirements
- CLI-based interface with ASCII art and colors  
- Error handling and exceptions  
- Informative messages and examples for user inputs  
- Input validation with retries  
- Timestamps in logs  

---

## ✨ Additional Functionalities
1. **Obstacle Detection** – SwiftBot detects obstacles and pauses until cleared.  
2. **LED Color Customization** – User chooses custom colors for odd/even sections.  
3. **ASCII Art UI** – Adds visual appeal and clarity.  
4. **QR Scan Timer** – 20-second limit with visual feedback.  

---

## 🔄 Changes to Functionalities
- **Visual indicators**:  
  - Yellow LEDs = scanning  
  - Red LEDs every 5s if scan fails  
  - Purple LEDs = successful scan  
- **Celebration Dive**: SwiftBot spins 360° with multicolored LEDs at the end.  
- **View logs directly** in command prompt with a provided command.  

---

## 🖥️ Changes to Algorithm & UI
- Variables renamed (`SLD`, `LSLD`, `SSLD`) for clarity.  
- Log file now updated **after every journey**, not just on exit.  
- Added **Button B**: lets user change LED colors after each journey.  
- Enhanced CLI formatting: bullet points, spacing, and colors.  

---

## 🧪 Testing
Testing was carried out continuously and documented in a structured plan.  

### Highlights:
- ✅ QR code validation (valid/invalid inputs).  
- ✅ Random speed generation and display.  
- ✅ Zigzag traversal and retracing path.  
- ✅ Correct LED behavior for odd/even sections.  
- ✅ Pause, errors, and obstacle handling.  
- ✅ Journey logs stored with timestamps and correct data.  
- ✅ Display of longest and shortest journeys before exiting.  
- ✅ Obstacle detection and recovery.  
- ✅ Color customization confirmed with multiple options.  

---

## 📅 Planning & Progress Tracking
### Programming (Week 1 – W/C 10/02/2025)
- Created the main method and connected button functionalities.  
- Implemented QR code scanning with SwiftBot API.  
- Developed zigzag movement with calibration.  
- Addressed movement inconsistencies with lecturer guidance.  

### User Interface (Week 4 – W/C 03/03/2025)
- CLI designed with ASCII art and colors.  
- Added bullet points and formatting for clarity.  
- Enhanced readability and user experience.  

### Testing & Reporting (Week 5 – W/C 10/03/2025)
- Incremental testing after coding each feature.  
- Final structured test plan created.  
- Report compiled with references, conclusion, and source code.  

---

## 📖 References
- Brunel.ac.uk. (2025). [Brightspace Lessons](https://brightspace.brunel.ac.uk/d2l/le/lessons/51578/topics/1769835).  
- Sharepoint.com. (2025). [Brunel 365 Sharepoint](https://brunel365-my.sharepoint.com/:x:/g/personal/csstyyj_brunel_ac_uk/ESc1tDLN9MFInds56tfLdkYBSw3RrJQKhBcZS_kjWLTEog?e=B12yRG) [Accessed 12 Mar. 2025].  
- Reposilite – JavaDoc. Available at: [SwiftBot API 5.1.3](https://swiftbot-maven.brunel.ac.uk/javadoc/releases/com/swiftbotlabs/SwiftBot-API/5.1.3).  

---
