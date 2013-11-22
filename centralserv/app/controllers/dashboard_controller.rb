class DashboardController < ApplicationController

  skip_before_filter :verify_authenticity_token, :except => [:index]

  def index
  end

  def attendance
    print "!!!!!!!!!!!!!"
    print params
  end

  def curriculum
    print "!!!!!!!!!!!!!"
    print params
  end

  def requests
    print "!!!!!!!!!!!!!"
    print params
  end

  def teachers
    print "!!!!!!!!!!!!!"
    print params
  end

  def inventory
    print "!!!!!!!!!!!!!"
    print params
  end

end
