package com.github.gwtbootstrap.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * A PasswordTextBox for Bootstrap form.
 * 
 * @since 2.0.3.0
 * 
 * @author ohashi keisuke
 * 
 */
public class PasswordTextBox extends TextBox {

	/**
	 * Creates a PasswordTextBox widget that wraps an existing &lt;input
	 * type='password'&gt; element.
	 * 
	 * This element must already be attached to the document. If the element is
	 * removed from the document, you must call
	 * {@link RootPanel#detachNow(Widget)}.
	 * 
	 * @param element
	 *            the element to be wrapped
	 */
	public static PasswordTextBox wrap(Element element) {
		// Assert that the element is attached.
		assert Document.get().getBody().isOrHasChild(element);

		PasswordTextBox textBox = new PasswordTextBox(element);

		// Mark it attached and remember it for cleanup.
		textBox.onAttach();
		RootPanel.detachOnWindowClose(textBox);

		return textBox;
	}

	/**
	 * Creates an empty password text box.
	 */
	public PasswordTextBox() {
		super(Document.get().createPasswordInputElement(), "gwt-PasswordTextBox");
	}

	/**
	 * This constructor may be used by subclasses to explicitly use an existing
	 * element. This element must be an &lt;input&gt; element whose type is
	 * 'password'.
	 * 
	 * @param element
	 *            the element to be used
	 */
	protected PasswordTextBox(Element element) {
		super(element, null);
		assert InputElement.as(element).getType().equalsIgnoreCase("password");
	}
}
