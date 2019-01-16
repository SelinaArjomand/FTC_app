package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by apple on 8/5/18.
 */

@TeleOp(name = "WalnutFamFest" , group = "Pushbot")

public class WalnutFamFest extends OpMode {

    public DcMotor leftfront;
    public DcMotor leftback;
    public DcMotor rightfront;
    public DcMotor rightback;


    @Override
    public void init() {
        leftfront = hardwareMap.dcMotor.get("leftfront");
        leftback = hardwareMap.dcMotor.get("leftback");
        rightfront = hardwareMap.dcMotor.get("rightfront");
        rightback = hardwareMap.dcMotor.get("rightback");

        rightback.setDirection(DcMotorSimple.Direction.REVERSE);
        rightfront.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
    }

    @Override
    public void loop() {
        float x;
        float y;
        float z;


        if (Math.abs(gamepad1.left_stick_x) > .1)
            x = -gamepad1.left_stick_x;
        else
            x = 0;

        if (Math.abs(gamepad1.left_stick_y) > .1)
            y = gamepad1.left_stick_y;
        else
            y = 0;

        if (Math.abs(gamepad1.right_stick_x) > .1)
            z = -gamepad1.right_stick_x;
        else
            z = 0;


        leftback.setPower(x - y - z);
        leftfront.setPower(-x - y - z);
        rightback.setPower(-x - y + z);
        rightfront.setPower(x - y +z);


    }

}


