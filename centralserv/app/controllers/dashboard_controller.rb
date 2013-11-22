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
    name = params["dashboard"].fetch("_json")[0].fetch('name')
    role = params["dashboard"].fetch("_json")[0].fetch('role')
    grade = params["dashboard"].fetch("_json")[0].fetch('gradesTaught')
    school = School.find(1)
    Staff.create(school: school, name: name, role: role)

  end

  def inventory
    print "!!!!!!!!!!!!!"
    name = params["dashboard"].fetch("_json")[0].fetch('title')
    description = params["dashboard"].fetch("_json")[0].fetch('description')
    school = School.find(1)
    resource = Resource.find(20)
    request = Requests.create(name: name, description: description, resource: [resource])
    resource.requests << request
    request.resources << resource
    resource.update_all
    request.update_all
    school.requests << request
    school.update_all
    Request.create(school: school, resources: [resource], name: name, image_url: "http://www.theniles.org/media/articles/2012_10_04_Aping_Morbe.jpg")

  end

end
