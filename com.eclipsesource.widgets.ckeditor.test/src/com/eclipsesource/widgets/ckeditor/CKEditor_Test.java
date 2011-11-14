package com.eclipsesource.widgets.ckeditor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import junit.framework.TestCase;

import org.eclipse.rap.rwt.testfixture.Fixture;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class CKEditor_Test extends TestCase {
  
  private Display display;
  private Shell shell;
  private Browser browser;
  private CKEditor editor;

  
  @Override
  protected void setUp() throws Exception {
    Fixture.setUp();
    display = new Display();
    shell = new Shell( display );
    browser = mock( Browser.class );
    editor = new CKEditor( shell, SWT.NONE, browser );
  }
  
  @Override
  protected void tearDown() throws Exception {
    Fixture.tearDown();
  }
  
  public void testUrl() {
    verify( browser ).setUrl( "/resources/ckeditor.html" );
  }
  
  public void testGetLayout() {
    assertTrue( editor.getLayout() instanceof FillLayout );
  }

  public void testSetLayout() {
    try {
      editor.setLayout( new FillLayout() );
      fail();
    } catch( UnsupportedOperationException ex ) {
      // expected
    }
  }

}