package org.apache.wicket.portlet.examples;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.IRequestCycleProvider;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.UrlRenderer;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.cycle.RequestCycleContext;
import org.apache.wicket.settings.ISecuritySettings;
import org.apache.wicket.util.crypt.ClassCryptFactory;
import org.apache.wicket.util.crypt.NoCrypt;
import org.apache.wicket.util.lang.Args;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see wicket.myproject.Start#main(String[])
 */
public abstract class WicketPortletExampleApplication extends WebApplication {
  /**
   * prevent wicket from launching a java application window on the desktop <br/>
   * once someone uses awt-specific classes java will automatically do so and allocate a window
   * unless you tell java to run in 'headless-mode'
   */
  static
  {
    System.setProperty("java.awt.headless", "true");
  }


  /**
   * Constructor.
   */
  public WicketPortletExampleApplication()
  {
  }

  /**
   * @see org.apache.wicket.protocol.http.WebApplication#init()
   */
  @Override
  protected void init()
  {
    // WARNING: DO NOT do this on a real world application unless
    // you really want your app's passwords all passed around and
    // stored in unencrypted browser cookies (BAD IDEA!)!!!

    // The NoCrypt class is being used here because not everyone
    // has the java security classes required by Crypt installed
    // and we want them to be able to run the examples out of the
    // box.
    getSecuritySettings().setCryptFactory(
      new ClassCryptFactory(NoCrypt.class, ISecuritySettings.DEFAULT_ENCRYPTION_KEY));

    getDebugSettings().setDevelopmentUtilitiesEnabled(true);
  }}
