/*
 * =====================================================================================
 *
 *       ProjectName: 3D&T Online
 *
 *        Version:  1.0
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Anderson de França Queiroz , anderson.f.queiroz(.AT,)gmail dot com
 *                  Felipe Jun Ichi Shimura , felipe-shimura(.AT,)hotmail dot com
 *		    Tiago de França Queiroz , tiago.f.q(.AT,)gmail dot com
 *        Company:  Universidade Federal do ABC - UFABC
 *	  License: GPL 3.0
 *
 * =====================================================================================
 */

package rpg;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class RPG extends SingleFrameApplication
{

        /**
         * At startup create and show the main frame of the application.
         */
        @Override
        protected void startup ()
        {
                //show (new Frame_Ficha());
                show(new RPG_Janela_Prinicpal(this));
                //show (new Frame_Ficha(new Ficha("Teste", "lalalla")));
        }

        /**
         * This method is to initialize the specified window by injecting resources.
         * Windows shown in our application come fully initialized from the GUI
         * builder, so this additional configuration is not needed.
         */
        @Override
        protected void configureWindow (java.awt.Window root)
        {
        }

        /**
         * A convenient static getter for the application instance.
         * @return the instance of RPG
         */
        public static RPG getApplication ()
        {
                return Application.getInstance(RPG.class);
        }

        /**
         * Main method launching the application.
         */
        public static void main (String[] args)
        {
                launch(RPG.class, args);
        }
}
