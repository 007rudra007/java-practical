/**
 * Practical 4 - Program 4: Single Inheritance – Smart Home Automation System
 *
 * Requirements:
 * 1. Base Class: Device
 *    - Data members: Device ID, Device Name, Power Status (ON/OFF)
 * 2. Derived Class: SmartLight (inherits from Device)
 *    - Data members: Brightness Level, Color Mode
 * 3. Constructors to initialize all details (using super).
 * 4. Methods:
 *    - Turn device ON/OFF
 *    - Change brightness level
 *    - Display device information
 * 5. Demonstrate inheritance in main().
 */
class Device {
    protected String deviceId;
    protected String deviceName;
    protected boolean powerStatus; // true = ON, false = OFF

    // Parameterized Constructor
    public Device(String deviceId, String deviceName, boolean powerStatus) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.powerStatus = powerStatus;
    }

    // Turn device ON
    public void turnOn() {
        this.powerStatus = true;
        System.out.println("[" + deviceName + "] is now turned ON.");
    }

    // Turn device OFF
    public void turnOff() {
        this.powerStatus = false;
        System.out.println("[" + deviceName + "] is now turned OFF.");
    }

    // Display device information
    public void displayDeviceInfo() {
        System.out.println("Device ID       : " + deviceId);
        System.out.println("Device Name     : " + deviceName);
        System.out.println("Power Status    : " + (powerStatus ? "ON" : "OFF"));
    }
}

// Derived class demonstrating Single Inheritance
class SmartLight extends Device {
    private int brightnessLevel; // 0 - 100%
    private String colorMode;

    // Constructor initializing both base and derived class members
    public SmartLight(String deviceId, String deviceName, boolean powerStatus,
                      int brightnessLevel, String colorMode) {
        super(deviceId, deviceName, powerStatus); // Call base class constructor
        this.brightnessLevel = brightnessLevel;
        this.colorMode = colorMode;
    }

    // Change brightness level
    public void changeBrightness(int level) {
        if (!powerStatus) {
            System.out.println("Cannot adjust brightness. [" + deviceName + "] is currently OFF. Turn it ON first.");
            return;
        }

        if (level >= 0 && level <= 100) {
            this.brightnessLevel = level;
            System.out.println("[" + deviceName + "] Brightness updated to: " + brightnessLevel + "%");
        } else {
            System.out.println("Invalid brightness level. Please enter a value between 0 and 100.");
        }
    }

    // Change color mode
    public void changeColorMode(String colorMode) {
        if (!powerStatus) {
            System.out.println("Cannot change color mode. [" + deviceName + "] is currently OFF.");
            return;
        }
        this.colorMode = colorMode;
        System.out.println("[" + deviceName + "] Color Mode changed to: " + colorMode);
    }

    // Overridden method to display complete device information
    @Override
    public void displayDeviceInfo() {
        System.out.println("----------------------------------------------");
        super.displayDeviceInfo(); // Display base class details
        System.out.println("Brightness Level: " + brightnessLevel + "%");
        System.out.println("Color Mode      : " + colorMode);
        System.out.println("----------------------------------------------");
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 4.4: Smart Home Automation System     ");
        System.out.println("==================================================");

        // 5. Create a SmartLight object and demonstrate inheritance
        SmartLight livingRoomLight = new SmartLight("DEV-LT-101", "Living Room Smart Chandelier", false, 50, "Warm White");

        System.out.println("\n--- Initial Device State ---");
        livingRoomLight.displayDeviceInfo();

        System.out.println("\n--- Interacting with SmartLight ---");
        // Attempting to change brightness while device is OFF
        livingRoomLight.changeBrightness(80);

        // Turning device ON (inherited method from Device)
        livingRoomLight.turnOn();

        // Adjusting brightness and color mode (SmartLight methods)
        livingRoomLight.changeBrightness(85);
        livingRoomLight.changeColorMode("Cool Daylight");

        System.out.println("\n--- Updated Device State ---");
        livingRoomLight.displayDeviceInfo();

        // Turning device OFF
        livingRoomLight.turnOff();
    }
}
