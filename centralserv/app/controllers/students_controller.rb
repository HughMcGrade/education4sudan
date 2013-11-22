class StudentsController < ApplicationController

  def index
    @staff = Staff.find(params[:id])
  end

  def new
    @student = Student.new
  end

  def show
    @student = Student.find(params[:id])
  end
  
  def create
  end

end
