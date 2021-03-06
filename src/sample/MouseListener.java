package sample;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

import java.util.ArrayList;
import java.util.List;


public class MouseListener implements NativeMouseInputListener {

    public static List<MouseCoordinates> mouseState = new ArrayList<>();
    public static List<MouseCoordinates> savedMouseState = new ArrayList<>();
    //0 is moving, 1 is pressed, 2 is released, 3 is click
    int mouseDoing = 0;

    public void nativeMouseClicked(NativeMouseEvent e) {
        System.out.println("Mouse Clicked: " + e.getClickCount());
    }

    public void nativeMousePressed(NativeMouseEvent e) {
        System.out.println("Mouse Pressed: " + e.getButton());
        mouseDoing = 1;
    }

    public void nativeMouseReleased(NativeMouseEvent e) {
        System.out.println("Mouse Released: " + e.getButton());
        if(mouseDoing == 1) {
            mouseDoing = 3;
        } else {
            mouseDoing = 2;
        }
    }

    public void nativeMouseMoved(NativeMouseEvent e) {
        /*if (mouseDoing == 0 && RecordAndPlay.isRecording) {
            mouseCoordinate = new MouseCoordinates(e.getX(), e.getY(), 0);
            mouseState.add(mouseCoordinate);
        }
        if (mouseDoing == 1 && RecordAndPlay.isRecording) {
            mouseCoordinate = new MouseCoordinates(e.getX(), e.getY(), 1);
            mouseState.add(mouseCoordinate);
            mouseDoing = 0;
        }
        if (mouseDoing == 2 && RecordAndPlay.isRecording) {
            mouseCoordinate = new MouseCoordinates(e.getX(), e.getY(), 2);
            mouseState.add(mouseCoordinate);
            mouseDoing = 0;
        }
        if (mouseDoing == 3 && RecordAndPlay.isRecording) {
            mouseCoordinate = new MouseCoordinates(e.getX(), e.getY(), 3);
            mouseState.add(mouseCoordinate);
            mouseDoing = 0;
        }*/
        if(RecordAndPlay.isRecording) {
            switch(mouseDoing) {
                case 0:
                    mouseState.add(new MouseCoordinates(e.getX(), e.getY(), 0));
                    break;
                case 1:
                    mouseState.add(new MouseCoordinates(e.getX(), e.getY(), 1));
                    mouseDoing = 0;
                    break;
                case 2:
                    mouseState.add(new MouseCoordinates(e.getX(), e.getY(), 2));
                    mouseDoing = 0;
                    break;
                case 3:
                    mouseState.add(new MouseCoordinates(e.getX(), e.getY(), 3));
                    mouseDoing = 0;
                    break;
            }
        }
    }

    public void nativeMouseDragged(NativeMouseEvent e) {
        /*if (mouseDoing == 0 && RecordAndPlay.isRecording) {
            mouseCoordinate = new MouseCoordinates(e.getX(), e.getY(), 0);
            mouseState.add(mouseCoordinate);
        }
        if (mouseDoing == 1 && RecordAndPlay.isRecording) {
            mouseCoordinate = new MouseCoordinates(e.getX(), e.getY(), 1);
            mouseState.add(mouseCoordinate);
            mouseDoing = 0;
        }
        if (mouseDoing == 2 && RecordAndPlay.isRecording) {
            mouseCoordinate = new MouseCoordinates(e.getX(), e.getY(), 2);
            mouseState.add(mouseCoordinate);
            mouseDoing = 0;
        }*/
        if(RecordAndPlay.isRecording) {
            switch(mouseDoing) {
                case 0:
                    mouseState.add(new MouseCoordinates(e.getX(), e.getY(), 0));
                    break;
                case 1:
                    mouseState.add(new MouseCoordinates(e.getX(), e.getY(), 1));
                    mouseDoing = 0;
                    break;
                case 2:
                    mouseState.add(new MouseCoordinates(e.getX(), e.getY(), 2));
                    mouseDoing = 0;
                    break;
            }
        }
    }
}
