/**
*
* Copyright (C) 2006-2009 Anton Gravestam.
*
* This file is part of OPS (Open Publish Subscribe).
*
* OPS (Open Publish Subscribe) is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.

* OPS (Open Publish Subscribe) is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with OPS (Open Publish Subscribe).  If not, see <http://www.gnu.org/licenses/>.
*/

package ops;

import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author angr
 */
public class DeadlineMissedFilterQoSPolicy extends Observable implements FilterQoSPolicy, Runnable
{
    
    long maxSeparation;

    private boolean stopped = false;
    boolean newUpdate = false;
    
    /** Creates a new instance of DeadlineMissedFilterQoSPolicy */
    public DeadlineMissedFilterQoSPolicy(long maxSeparation)
    {
        this.maxSeparation = maxSeparation;
        
        Thread t = new Thread(this);
        t.start();
        
        
        
    }
    
    public boolean applyFilter(OPSObject o)
    {
        newUpdate = true;
        return true;
    }
    public void stop()
    {
        stopped = true;
    }

    public void run()
    {
        try
        {
            while(!stopped)
            {
                Thread.sleep(maxSeparation);
                if(!newUpdate)
                {
                    setChanged();
                    notifyObservers();   
                }
                newUpdate = false;
                
            }
        } 
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
            
        }
    }
    

    
    
    
    
}

