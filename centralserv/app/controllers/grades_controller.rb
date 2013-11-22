class GradesController < ApplicationController

  def index
    @grades = Grade.all
  end

  def show
    @grade = Grade.find(params[:id])
    session[:grade_id] = params[:id]
    @curriculum = Curriculum.new
  end

end
