require 'json'

class DashboardController < ApplicationController

  skip_before_filter :verify_authenticity_token, :except => [:index]

  def index
  end

  def attendance
    print "!!!!!!!!!!!!!"
    print "?????"
    obj = params["dashboard"].fetch("_json")[0].fetch("name")
    print obj
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
    name = params["dashboard"].fetch("_json")[0].fetch('title')
    description = params["dashboard"].fetch("_json")[0].fetch('title')
    Request.create(name: name, description: description, school_id: 1)
  end

end
