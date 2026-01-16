package org.wildstang.sample.subsystems;

import org.wildstang.framework.io.inputs.Input;
import org.wildstang.framework.subsystems.Subsystem;
import org.wildstang.hardware.roborio.inputs.WsJoystickAxis;
import org.wildstang.hardware.roborio.outputs.WsSpark;
import org.wildstang.sample.robot.WsInputs;
import org.wildstang.sample.robot.WsOutputs;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Turret implements Subsystem
{
    double flywheelReduction = 1;
    double hoodReduction = -0.5;
    double kickerReduction = 0.5;
    double rotationReduction = -0.5;

    WsJoystickAxis leftTrigger, rightTrigger, leftJoystickX, rightJoystickY;
    WsSpark flywheelLeft, flywheelRight, hood, kicker, angle;

    double flywheelSpeed, hoodSpeed, kickerSpeed, rotationSpeed;

    @Override
    public void init()
    {
        leftTrigger = (WsJoystickAxis) WsInputs.DRIVER_LEFT_TRIGGER.get();
        leftTrigger.addInputListener(this);
        rightTrigger = (WsJoystickAxis) WsInputs.DRIVER_RIGHT_TRIGGER.get();
        rightTrigger.addInputListener(this);
        leftJoystickX = (WsJoystickAxis) WsInputs.DRIVER_LEFT_JOYSTICK_HORIZONTAL.get();
        leftJoystickX.addInputListener(this);
        rightJoystickY = (WsJoystickAxis) WsInputs.DRIVER_RIGHT_JOYSTICK_VERTICAL.get();
        rightJoystickY.addInputListener(this);

        flywheelLeft = (WsSpark) WsOutputs.TURRET_FLYWHEEL_LEFT.get();
        flywheelRight = (WsSpark) WsOutputs.TURRET_FLYWHEEL_RIGHT.get();
        hood = (WsSpark) WsOutputs.TURRET_HOOD.get();
        kicker = (WsSpark) WsOutputs.TURRET_KICKER.get();
        angle = (WsSpark) WsOutputs.TURRET_ANGLE.get();
    }

    @Override
    public void inputUpdate(Input source) {
        if (source == leftTrigger)
        {
            if (Math.abs(leftTrigger.getValue()) > 0.1)
            {
                kickerSpeed = leftTrigger.getValue() * kickerReduction;
            }
            else
            {
                kickerSpeed = 0;
            }
        }
        else if (source == rightTrigger)
        {
            if (Math.abs(rightTrigger.getValue()) > 0.1)
            {
                flywheelSpeed = rightTrigger.getValue() * flywheelReduction;
            }
            else
            {
                flywheelSpeed = 0;
            }
        }
        else if (source == leftJoystickX)
        {
            if (Math.abs(leftJoystickX.getValue()) > 0.1)
            {
                rotationSpeed = leftJoystickX.getValue() * rotationReduction;
            }
            else
            {
                rotationSpeed = 0;
            }
        }
        else if (source == rightJoystickY)
        {
            if (Math.abs(rightJoystickY.getValue()) > 0.1)
            {
                hoodSpeed = rightJoystickY.getValue() * hoodReduction;
            }
            else
            {
                hoodSpeed = 0;
            }
        }
    }

    @Override
    public void update() {
        SmartDashboard.putNumber("Flywheel Speed", flywheelSpeed);
        SmartDashboard.putNumber("Hood Speed", hoodSpeed);
        SmartDashboard.putNumber("Kicker Speed", kickerSpeed);
        SmartDashboard.putNumber("Rotation Speed", rotationSpeed);

        flywheelLeft.setSpeed(flywheelSpeed);
        flywheelRight.setSpeed(-1 * flywheelSpeed);
        hood.setSpeed(hoodSpeed);
        kicker.setSpeed(kickerSpeed);
        angle.setSpeed(rotationSpeed);
    }

    @Override
    public void selfTest() {
    }

    @Override
    public void resetState() {
    }

    @Override
    public void initSubsystems() {
    }

    @Override
    public String getName() {
        return "Turret";
    }
    
}
