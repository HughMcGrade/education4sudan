class SchoolsController < ApplicationController

  def index
  	@schools = School.all
  	@schools = @schools.map {|school| school.location}.join("|")

	@names = School.all
    @ids = @names.map {|school| school.id}.join("|")
    @names = @names.map {|school| school.name}.join("|")

  end

  def show
    @school = School.find(params[:id])

    @staff = Staff.new
    
    @staffs = Staff.where(school_id: @school.id)
    @resources = []
    @requests = Request.where(school: @school)
    @requests.each do |request|
      @resources << request.resources
    end
    @resources = @resources.flatten
    
  end

end
