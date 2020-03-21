/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class GameWorld implements World, Container {

    private static int MAX_TIME = 1 * 60 * 1000;	// 1 minute
    private static int Timer = 1 * 1 * 1000;
    Random r = new Random();
    int time1 = 1;
    int pn = 0;
    Snapshot ss = new Snapshot();
    private int scoreold;
    private int score = 0;
    private long startTime = System.currentTimeMillis();
    private final int width;
    private final int height;
    public static int speed = 10;
    public static int controlSpeed = 20;
    private String shapes[] = {"plate", "ball", "object"};
    private final List<GameObject> constant = new LinkedList<>();
    private final List<GameObject> moving = new LinkedList<>();
    private final List<GameObject> control = new LinkedList<>();
    private final List<GameObject> plateleft = new LinkedList<>();
    private final List<GameObject> plateright = new LinkedList<>();
    File file = new File("memento.txt");
    StateContext context = new StateContext();
    StartState startState = new StartState();
    Subject subject = new Subject();
    Originator originator = new Originator();
    CareTaker careTaker = new CareTaker();

    private int controlsize;
    DynamicLinkage dl = new DynamicLinkage();

    private ShapeFactory shapeFactory = new ShapeFactory();

    int k = 0, n = 0, j = 0;

    public GameWorld(int screenWidth, int screenHeight) throws FileNotFoundException {
        this.score = ss.getScore();
        width = screenWidth;
        height = screenHeight;
        constant.add(new ImageObject(0, 0, "/back2.jpg", 0));
        constant.add(new BarObject(10, 30, width - 10, true, Color.GRAY));
        constant.add(new BarObject(10, 90, width - 10, true, Color.red));
        control.add(new ImageObject(width / 2, height - 150, "/clown2.png", 0));
        control.add(new ImageObject((width / 2) + 18, height - 150, "/lefthand3.png", 0));
        control.add(new ImageObject((width / 2) + 104, height - 150, "/righthand3.png", 0));
        new ControlSpeedObserver(subject);
        new MovingSpeedObserver(subject);
        subject.setState(score);
        constant.add(new ImageObject(0, 480, "/level 1.png", 0));
        Date date = new Date();
        PrintWriter out;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            out.println(date.toString());
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(GameWorld.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean refresh() {
        controlsize = control.size();
        scoreold = score;
        for (GameObject gameobject : moving) {
            Shape p = (Shape) gameobject;
            startState.doAction(control, p, time1, context);
            /*else if (p.getType()==3){  
               p.setX(control.get(0).getX()); 
        }*/
            if (intersect(p, control.get(1))) {
                control.add(p);
                plateleft.add(p);
                p.setX(control.get(1).getX() - 20);
                p.setY(control.get(1).getY() - k);
                k = k + 10;
                p.setType(3);
                if (p.getY() < 100) {
                    try {
                        ss.setScore(0);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(GameWorld.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return false;
                }
            } else if (intersect(p, control.get(2))) {

                //ImageObject s = new ImageObject(p.getX(), p.getY(), p.getPath(), p.getType());
                control.add(p);
                plateright.add(p);
                p.setX(control.get(2).getX() - 25);
                p.setY(control.get(2).getY() - n);
                n += 10;
                p.setType(2);
                if (p.getY() < 100) {
                    try {
                        ss.setScore(0);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(GameWorld.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return false;
                }
            }
        }
        for (GameObject shape : control) {
            moving.remove(shape);
        }
        if (plateleft.size() >= 3) {
            Shape p1 = (Shape) plateleft.get(plateleft.size() - 1);
            Shape p2 = (Shape) plateleft.get(plateleft.size() - 2);
            Shape p3 = (Shape) plateleft.get(plateleft.size() - 3);
            if (p1.getColor().equals(p2.getColor()) && p2.getColor().equals(p3.getColor())) {
                control.remove(p1);
                control.remove(p2);
                control.remove(p3);
                plateleft.remove(p1);
                plateleft.remove(p2);
                plateleft.remove(p3);
                score++;
                subject.setState(score);

                k -= 30;
                originator.setState(this.getStatus());
                careTaker.add(originator.saveStateToMemento());
                try {
                    ss.setScore(score);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GameWorld.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        if (plateright.size() >= 3) {
            Shape p1 = (Shape) plateright.get(plateright.size() - 1);
            Shape p2 = (Shape) plateright.get(plateright.size() - 2);
            Shape p3 = (Shape) plateright.get(plateright.size() - 3);

            if (p1.getColor().equals(p2.getColor()) && p2.getColor().equals(p3.getColor())) {
                control.remove(p1);
                control.remove(p2);
                control.remove(p3);
                plateright.remove(p1);
                plateright.remove(p2);
                plateright.remove(p3);
                score++;
                subject.setState(score);
                n -= 30;
                originator.setState(this.getStatus());
                careTaker.add(originator.saveStateToMemento());
                try {
                    ss.setScore(score);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GameWorld.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        if ((control.get(0).getX() + control.get(0).getWidth()) >= width) {
            for (int l = 0; l < control.size(); l++) {

                control.get(l).setX((int) (control.get(l).getX() - (width - width * 0.13)));
            }
        }
        if ((control.get(0).getX()) <= 0) {
            for (int l = 0; l < control.size(); l++) {
                control.get(l).setX((int) (control.get(l).getX() + (width - width * 0.13)));
            }
        }
        try {
            if (dl.getPaths() != null) {
                addShape(shapes[r.nextInt(3)]);
            } else {
                addShape(shapes[r.nextInt(2)]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (controlsize != control.size()) {
            controlsize = control.size();
            plateiterator();

        }
        if (scoreold != score) {
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                out.println(originator.getState());
                out.close();
            } catch (IOException e) {
                //exception handling left as an exercise for the reader
            }
        }

        return true;

    }

    private boolean intersect(Shape o1, GameObject Clown) {
        return (Math.abs((o1.getX() + o1.getWidth() / 2) - (Clown.getX() + Clown.getWidth() / 2)) <= o1.getWidth()) && (Math.abs((o1.getY() + o1.getHeight() / 2) - (Clown.getY() + Clown.getHeight() / 2)) <= o1.getHeight());
    }

    private void addShape(String shape) throws FileNotFoundException {
        if ((System.currentTimeMillis() - startTime) >= Timer) {
            startTime = System.currentTimeMillis();
            shapeFactory.addShape(shape, width, moving);
            time1++;
            checktime();
        }
    }

    private void checktime() {
        if (time1 == 4 || time1 == 34 || time1 == 64) {
            constant.remove(3);
        } else if (time1 == 30) {
            constant.add(new ImageObject(0, 480, "/level 2.png", 0));
        } else if (time1 == 60) {
            constant.add(new ImageObject(0, 480, "/level 3.png", 0));
        }
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public int getControlSpeed() {
        return this.controlSpeed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setControlSpeed(int controlSpeed) {
        this.controlSpeed = controlSpeed;
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getStatus() {
        if (time1 > 65) {
            return ("Score=" + score + "   |   Time=" + time1 + "   |   No. of objects=" + pn + "   |   Level=3");	// update status
        } else {
            return ("Score=" + score + "   |   Time=" + time1 + "   |   No. of objects=" + pn + "   |   Level=" + (Math.floorDiv(time1, 30) + 1));	// update status
        }
    }

    @Override
    public Iterator getIterator() {
        return new PlateIterator();
    }

    public class PlateIterator implements Iterator {

        private int index = 3;

        @Override
        public boolean hasNext() {
            if (control.size() > index) {
                return true;
            }
            return false;
        }

        @Override
        public int next() {
            return (control.size() - 3);
        }

    }

    private void plateiterator() {
        Iterator i = this.getIterator();
        if (i.hasNext()) {
            pn = i.next();
            System.out.println("no of objects in hands          " + pn);
        }
    }

}
