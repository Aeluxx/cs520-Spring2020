import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import model.FigureModel;
import view.FigureView;
import javax.swing.ImageIcon;

public class FigureEditorTests
{
    @Test
    public void testNewFigureModel() {
		FigureModel model = new FigureModel();
		Assert.assertNotNull(model);
		Assert.assertNull(model.getImage());
		Assert.assertNull(model.getCaption());
    }

	@Test(expected = IllegalArgumentException.class)
	public void testNullImage() {
		FigureModel model = new FigureModel();
		model.setImage(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullCaption() {
		FigureModel model = new FigureModel();
		model.setCaption(null);
	}

	@Test
	public void testGetSet() {
		FigureModel model = new FigureModel();
		ImageIcon test_img = new ImageIcon("");
		String test_cap = "something";
		model.setImage(test_img);
		model.setCaption(test_cap);
		Assert.assertEquals(model.getImage(), test_img);
		Assert.assertEquals(model.getCaption(), "something");
	}

	@Test
	public void testGetMethodsNull() {
		FigureModel model = new FigureModel();
		Assert.assertEquals(model.getImage(), null);
		Assert.assertEquals(model.getCaption(), null);
	}

	@Test
	public void testObservationCaption() {
		FigureView observer = new FigureView();
		FigureModel observable = new FigureModel();
		observable.addObserver(observer);
		observable.setCaption("observation!");
		Assert.assertEquals(observer.getViewText(), "observation!");
	}

	@Test
	public void testObservationImage() {
		ImageIcon test_img = new ImageIcon("");
		FigureView observer = new FigureView();
		FigureModel observable = new FigureModel();
		observable.addObserver(observer);
		observable.setImage(test_img);
		Assert.assertEquals(observer.getViewIcon(), test_img);
	}
}
