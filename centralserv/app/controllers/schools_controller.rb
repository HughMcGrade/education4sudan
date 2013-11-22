class SchoolsController < ApplicationController

  def index
  	@schools = School.all
  	@schools = @schools.map {|school| school.location}.join("|")

	@names = School.all
  	@names = @names.map {|school| school.name}.join("|")

  end

  def show
    @school = School.find(params[:id])

    @staffs = Staff.where({school_id:1})

    @resources = @school.requests.map {|request| request.resources}.flatten

  end

end
