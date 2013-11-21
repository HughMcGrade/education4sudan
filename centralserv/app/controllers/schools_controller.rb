class SchoolsController < ApplicationController

  def index
  	@schools = School.all
  	@schools = @schools.map {|school| school.location}.join("|")

	@names = School.all
  	@names = @names.map {|school| school.name}.join("|")

  end

  def show
  end

end
