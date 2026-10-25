package tasks.task5.view;

import tasks.task5.model.DrawShape;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class DrawFrame extends JFrame
{

    private PaintSurface surface;

    public DrawFrame(String title)
    {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        surface = new PaintSurface();

        this.add(setButtonPanel(), BorderLayout.NORTH);
        this.add(surface, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    private JPanel setButtonPanel()
    {
        JPanel buttonPanel = new JPanel(true);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.CYAN);
        buttonPanel.setBorder(new LineBorder(Color.BLACK, 2));

        BigTextButton rect = new BigTextButton("Rectangle");
        rect.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_RECTANGLE));
        buttonPanel.add(rect);

        BigTextButton roundedRect = new BigTextButton("Rounded rect");
        roundedRect.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_ROUNDED_RECT));
        buttonPanel.add(roundedRect);

        BigTextButton ellipse = new BigTextButton("Ellipse");
        ellipse.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_ELLIPSE));
        buttonPanel.add(ellipse);

        BigTextButton clear = new BigTextButton("Clear");
        clear.addActionListener(e -> surface.clearShapes());
        buttonPanel.add(clear);

        return buttonPanel;
    }
}