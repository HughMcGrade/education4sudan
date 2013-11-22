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
    @student = Student.create(student_params)
    redirect_to school_path(@student.staff.school.id), :notice => "Student added successfully!"
  end

  private

  def student_params
    params.require(:student).permit(:name, :age, :gender, :contact, :grade_id, :staff_id)
  end

end
